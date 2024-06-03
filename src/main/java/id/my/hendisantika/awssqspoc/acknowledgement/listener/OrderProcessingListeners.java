package id.my.hendisantika.awssqspoc.acknowledgement.listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode;
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:16
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class OrderProcessingListeners {

    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingListeners.class);

    private final InventoryService inventoryService;

    private final OrderService orderService;

    @SqsListener(value = "${events.queues.order-processing-retry-queue}", id = "retry-order-processing-container", messageVisibilitySeconds = "1")
    public void stockCheckRetry(OrderCreatedEvent orderCreatedEvent) {
        logger.info("Message received: {}", orderCreatedEvent);

        orderService.updateOrderStatus(orderCreatedEvent.id(), OrderStatus.PROCESSING);
        inventoryService.checkInventory(orderCreatedEvent.productId(), orderCreatedEvent.quantity());
        orderService.updateOrderStatus(orderCreatedEvent.id(), OrderStatus.PROCESSED);
        logger.info("Message processed successfully: {}", orderCreatedEvent);
    }

    @SqsListener(value = "${events.queues.order-processing-async-queue}", acknowledgementMode = SqsListenerAcknowledgementMode.MANUAL, id = "async-order-processing-container", messageVisibilitySeconds = "3")
    public void slowStockCheckAsynchronous(OrderCreatedEvent orderCreatedEvent, Acknowledgement acknowledgement) {
        logger.info("Message received: {}", orderCreatedEvent);

        orderService.updateOrderStatus(orderCreatedEvent.id(), OrderStatus.PROCESSING);
        CompletableFuture.runAsync(() -> inventoryService.slowCheckInventory(orderCreatedEvent.productId(), orderCreatedEvent.quantity()))
                .thenRun(() -> orderService.updateOrderStatus(orderCreatedEvent.id(), OrderStatus.PROCESSED))
                .thenCompose(voidFuture -> acknowledgement.acknowledgeAsync())
                .thenRun(() -> logger.info("Message for order {} acknowledged", orderCreatedEvent.id()));

        logger.info("Releasing processing thread.");
    }

    @SqsListener(value = "${events.queues.order-processing-no-retries-queue}", acknowledgementMode = "${events.acknowledgment.order-processing-no-retries-queue}", id = "no-retries-order-processing-container", messageVisibilitySeconds = "3")
    public void stockCheckNoRetries(OrderCreatedEvent orderCreatedEvent) {
        logger.info("Message received: {}", orderCreatedEvent);

        // Fire and forget scenario where we're not  interested on the outcome, e.g. a sales event with limited inventory.
        orderService.updateOrderStatus(orderCreatedEvent.id(), OrderStatus.RECEIVED);
        inventoryService.checkInventory(orderCreatedEvent.productId(), orderCreatedEvent.quantity());
        logger.info("Message processed: {}", orderCreatedEvent);
    }
}

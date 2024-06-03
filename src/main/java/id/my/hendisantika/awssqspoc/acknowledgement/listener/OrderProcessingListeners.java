package id.my.hendisantika.awssqspoc.acknowledgement.listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

}

package id.my.hendisantika.awssqspoc;

import id.my.hendisantika.awssqspoc.acknowledgement.EventsQueuesProperties;
import id.my.hendisantika.awssqspoc.acknowledgement.config.ProductIdProperties;
import id.my.hendisantika.awssqspoc.acknowledgement.model.OrderCreatedEvent;
import id.my.hendisantika.awssqspoc.acknowledgement.model.OrderStatus;
import id.my.hendisantika.awssqspoc.acknowledgement.service.OrderService;
import io.awspring.cloud.sqs.listener.MessageListenerContainerRegistry;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.shaded.org.awaitility.Awaitility;

import java.time.Duration;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:26
 * To change this template use File | Settings | File Templates.
 */
@ActiveProfiles("acknowledgement")
@SpringBootTest
class OrderProcessingApplicationLiveTest extends BaseSqsLiveTest {

    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingApplicationLiveTest.class);

    @Autowired
    private EventsQueuesProperties eventsQueuesProperties;

    @Autowired
    private ProductIdProperties productIdProperties;

    @Autowired
    private SqsTemplate sqsTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MessageListenerContainerRegistry registry;

    @Test
    public void givenOnSuccessAcknowledgementMode_whenProcessingThrows_shouldRetry() {
        var orderId = UUID.randomUUID();
        var queueName = eventsQueuesProperties.getOrderProcessingRetryQueue();
        sqsTemplate.send(queueName, new OrderCreatedEvent(orderId, productIdProperties.getLaptop(), 10));
        Awaitility.await()
                .atMost(Duration.ofMinutes(1))
                .until(() -> orderService.getOrderStatus(orderId)
                        .equals(OrderStatus.PROCESSED));
        assertQueueIsEmpty(queueName, "retry-order-processing-container");
    }

    @Test
    public void givenManualAcknowledgementMode_whenManuallyAcknowledge_shouldAcknowledge() {
        var orderId = UUID.randomUUID();
        var queueName = eventsQueuesProperties.getOrderProcessingAsyncQueue();
        sqsTemplate.send(queueName, new OrderCreatedEvent(orderId, productIdProperties.getSmartphone(), 1));
        Awaitility.await()
                .atMost(Duration.ofMinutes(1))
                .until(() -> orderService.getOrderStatus(orderId)
                        .equals(OrderStatus.PROCESSED));
        assertQueueIsEmpty(queueName, "async-order-processing-container");
    }

    @Test
    public void givenAlwaysAcknowledgementMode_whenProcessThrows_shouldAcknowledge() {
        var orderId = UUID.randomUUID();
        var queueName = eventsQueuesProperties.getOrderProcessingNoRetriesQueue();
        sqsTemplate.send(queueName, new OrderCreatedEvent(orderId, productIdProperties.getWirelessHeadphones(), 20));
        Awaitility.await()
                .atMost(Duration.ofMinutes(1))
                .until(() -> orderService.getOrderStatus(orderId)
                        .equals(OrderStatus.RECEIVED));
        assertQueueIsEmpty(queueName, "no-retries-order-processing-container");
    }
}

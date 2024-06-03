package id.my.hendisantika.awssqspoc;

import id.my.hendisantika.awssqspoc.acknowledgement.EventsQueuesProperties;
import id.my.hendisantika.awssqspoc.acknowledgement.config.ProductIdProperties;
import id.my.hendisantika.awssqspoc.acknowledgement.service.OrderService;
import io.awspring.cloud.sqs.listener.MessageListenerContainerRegistry;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
}

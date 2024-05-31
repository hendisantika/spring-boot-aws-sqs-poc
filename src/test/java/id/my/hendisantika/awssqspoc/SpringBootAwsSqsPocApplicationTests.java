package id.my.hendisantika.awssqspoc;

import id.my.hendisantika.awssqspoc.config.EventQueuesProperties;
import id.my.hendisantika.awssqspoc.repository.UserRepository;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("introduction")
class SpringBootAwsSqsPocApplicationTests extends BaseSqsLiveTest {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootAwsSqsPocApplicationTests.class);

    @Autowired
    private SqsTemplate sqsTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventQueuesProperties eventQueuesProperties;

    @Test
    void contextLoads() {
    }

}

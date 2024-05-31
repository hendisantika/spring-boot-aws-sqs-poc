package id.my.hendisantika.awssqspoc;

import id.my.hendisantika.awssqspoc.config.EventQueuesProperties;
import id.my.hendisantika.awssqspoc.model.UserCreatedEvent;
import id.my.hendisantika.awssqspoc.repository.UserRepository;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;
import java.util.UUID;

import static org.awaitility.Awaitility.await;

@Slf4j
@SpringBootTest
@ActiveProfiles("introduction")
class SpringBootAwsSqsPocApplicationTests extends BaseSqsLiveTest {

    @Autowired
    private SqsTemplate sqsTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventQueuesProperties eventQueuesProperties;

    @Test
    void givenAStringPayload_whenSend_shouldReceive() {
        // given
        var userName = "Itadori Yuji";

        // when
        sqsTemplate.send(to -> to.queue(eventQueuesProperties.getUserCreatedByNameQueue())
                .payload(userName));
        log.info("Message sent with payload {}", userName);

        // then
        await().atMost(Duration.ofSeconds(3))
                .until(() -> userRepository.findByName(userName)
                        .isPresent());
    }

    @Test
    void givenARecordPayload_whenSend_shouldReceive() {
        // given
        String userId = UUID.randomUUID()
                .toString();
        var payload = new UserCreatedEvent(userId, "Itadori Yuji", "yuji@yopmail.com");

        // when
        sqsTemplate.send(to -> to.queue(eventQueuesProperties.getUserCreatedRecordQueue())
                .payload(payload));

        // then
        log.info("Message sent with payload: {}", payload);
        await().atMost(Duration.ofSeconds(3))
                .until(() -> userRepository.findById(userId)
                        .isPresent());
    }


}

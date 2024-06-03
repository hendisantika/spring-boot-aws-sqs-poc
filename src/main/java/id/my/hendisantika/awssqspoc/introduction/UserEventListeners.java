package id.my.hendisantika.awssqspoc.introduction;

import id.my.hendisantika.awssqspoc.repository.UserRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:04
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
public class UserEventListeners {

    public static final String EVENT_TYPE_CUSTOM_HEADER = "eventType";

    private final UserRepository userRepository;

    public UserEventListeners(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SqsListener("${events.queues.user-created-by-name-queue}")
    public void receiveStringMessage(String username) {
        log.info("Received message: {}", username);
        userRepository.save(new User(UUID.randomUUID()
                .toString(), username, null));
    }

    @SqsListener(value = "${events.queues.user-created-record-queue}")
    public void receiveRecordMessage(UserCreatedEvent event) {
        log.info("Received message: {}", event);
        userRepository.save(new User(event.id(), event.username(), event.email()));
    }
}

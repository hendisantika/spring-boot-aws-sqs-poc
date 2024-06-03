package id.my.hendisantika.awssqspoc.introduction;

import id.my.hendisantika.awssqspoc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
}

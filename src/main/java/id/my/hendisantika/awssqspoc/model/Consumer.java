package id.my.hendisantika.awssqspoc.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
@Component
@Slf4j
public class Consumer {

    @SqsListener(value = "spring-boot-poc", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(Pojo message) {
        log.info("Message from SQS {}", message);
    }
}

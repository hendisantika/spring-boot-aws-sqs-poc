package id.my.hendisantika.awssqspoc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "events.queues")
@Data
public class EventQueuesProperties {
    private String userCreatedByNameQueue;
    private String userCreatedRecordQueue;
    private String userCreatedEventTypeQueue;
}

package id.my.hendisantika.awssqspoc.acknowledgement;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:12
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "events.queues")
@Getter
@Setter
public class EventsQueuesProperties {

    private String orderProcessingRetryQueue;

    private String orderProcessingAsyncQueue;

    private String orderProcessingNoRetriesQueue;
}

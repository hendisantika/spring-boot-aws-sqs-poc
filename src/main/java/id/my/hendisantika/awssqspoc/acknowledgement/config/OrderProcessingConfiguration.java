package id.my.hendisantika.awssqspoc.acknowledgement.config;

import id.my.hendisantika.awssqspoc.acknowledgement.EventsQueuesProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:13
 * To change this template use File | Settings | File Templates.
 */
@EnableConfigurationProperties({EventsQueuesProperties.class, ProductIdProperties.class})
@Configuration
public class OrderProcessingConfiguration {
}

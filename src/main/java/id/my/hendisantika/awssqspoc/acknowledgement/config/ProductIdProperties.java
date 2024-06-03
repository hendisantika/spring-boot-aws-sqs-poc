package id.my.hendisantika.awssqspoc.acknowledgement.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:14
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties("product.id")
@Getter
@Setter
public class ProductIdProperties {

    private UUID smartphone;

    private UUID wirelessHeadphones;

    private UUID laptop;
}

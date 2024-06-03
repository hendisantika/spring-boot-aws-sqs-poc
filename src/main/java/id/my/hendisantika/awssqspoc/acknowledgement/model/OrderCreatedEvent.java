package id.my.hendisantika.awssqspoc.acknowledgement.model;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:19
 * To change this template use File | Settings | File Templates.
 */
public record OrderCreatedEvent(UUID id, UUID productId, int quantity) {
}

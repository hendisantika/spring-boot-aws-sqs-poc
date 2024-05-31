package id.my.hendisantika.awssqspoc.model;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
public record UserCreatedEvent(String id, String username, String email) {
}

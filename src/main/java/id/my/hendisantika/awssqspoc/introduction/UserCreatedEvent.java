package id.my.hendisantika.awssqspoc.introduction;

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
public record UserCreatedEvent(String id, String username, String email) {
}

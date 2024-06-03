package id.my.hendisantika.awssqspoc.acknowledgement.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:15
 * To change this template use File | Settings | File Templates.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

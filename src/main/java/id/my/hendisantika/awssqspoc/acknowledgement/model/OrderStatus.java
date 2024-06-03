package id.my.hendisantika.awssqspoc.acknowledgement.model;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:20
 * To change this template use File | Settings | File Templates.
 */
public enum OrderStatus {
    RECEIVED,

    PROCESSING,

    PROCESSED,

    ERROR,

    UNKNOWN

}

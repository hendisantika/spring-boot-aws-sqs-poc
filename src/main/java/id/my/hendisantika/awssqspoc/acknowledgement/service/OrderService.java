package id.my.hendisantika.awssqspoc.acknowledgement.service;

import id.my.hendisantika.awssqspoc.acknowledgement.model.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:24
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderService {

    Map<UUID, OrderStatus> ORDER_STATUS_STORAGE = new ConcurrentHashMap<>();
}

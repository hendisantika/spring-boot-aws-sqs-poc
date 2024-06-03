package id.my.hendisantika.awssqspoc.acknowledgement.listener;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/3/24
 * Time: 07:16
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class OrderProcessingListeners {

    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingListeners.class);

    private final InventoryService inventoryService;

    private final OrderService orderService;

}

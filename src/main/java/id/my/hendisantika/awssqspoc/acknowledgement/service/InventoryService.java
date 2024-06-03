package id.my.hendisantika.awssqspoc.acknowledgement.service;

import id.my.hendisantika.awssqspoc.acknowledgement.config.ProductIdProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
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
 * Time: 07:21
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class InventoryService implements InitializingBean {

    private final ProductIdProperties productIdProperties;

    // Using a Map to simulate storage
    private Map<UUID, Integer> inventory;

    @Override
    public void afterPropertiesSet() {
        this.inventory = new ConcurrentHashMap<>(Map.of(productIdProperties.getSmartphone(), 10,
                productIdProperties.getWirelessHeadphones(), 15,
                productIdProperties.getLaptop(), 5));
    }
}

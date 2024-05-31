package id.my.hendisantika.awssqspoc.repository;

import id.my.hendisantika.awssqspoc.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-aws-sqs-poc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserRepository {
    private final Map<String, User> persistedUsers = new ConcurrentHashMap<>();

}

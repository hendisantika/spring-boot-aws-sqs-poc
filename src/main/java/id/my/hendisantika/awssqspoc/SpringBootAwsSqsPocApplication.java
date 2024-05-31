package id.my.hendisantika.awssqspoc;

import id.my.hendisantika.awssqspoc.config.EventQueuesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(EventQueuesProperties.class)
public class SpringBootAwsSqsPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsSqsPocApplication.class, args);
    }

}

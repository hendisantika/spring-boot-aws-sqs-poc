package id.my.hendisantika.awssqspoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootAwsSqsPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsSqsPocApplication.class, args);
    }

}

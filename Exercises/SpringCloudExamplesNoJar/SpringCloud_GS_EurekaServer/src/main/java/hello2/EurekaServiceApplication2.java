package hello2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication2.class, args);
    }
}
package hello;



import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientService {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientService.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

    @RequestMapping("/greeting/sayHi")
    public String serviceInstancesByApplicationName(HttpServletRequest request) { return "Hello from service. The Request url was =" + request.getRequestURL(); }
}
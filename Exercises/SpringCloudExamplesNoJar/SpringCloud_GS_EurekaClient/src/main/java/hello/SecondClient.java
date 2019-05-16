package hello;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;



// only if using feign 
@FeignClient("a-bootiful-client")
interface GreetingClient {
    @RequestMapping("/greeting/sayHi")
    String greeting();
}

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SecondClient {
 public static void main(String[] args) {
	 SpringApplication springApplication = new SpringApplication(SecondClient.class);
	 springApplication.setWebApplicationType(WebApplicationType.NONE);
	 ConfigurableApplicationContext context = springApplication.run(args);
//   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecondClient.class);
   
   DiscoveryClient discoveryClient = context.getBean(DiscoveryClient.class);
   List<ServiceInstance> instances = discoveryClient.getInstances("a-bootiful-client");
   ServiceInstance serviceInstance = instances.get(0);
   String hostname = serviceInstance.getHost();
   int port = serviceInstance.getPort();
   System.out.println("Found service at host " + hostname + " port " + port + " uri = " + serviceInstance.getUri());   
   String result = new RestTemplate().getForObject(serviceInstance.getUri()+"/greeting/sayHi",String.class);
   System.out.println("Service result = " + result);

//   // OLD/Depracated Client side round robin with pure eureka ( no round robbin )
//   InstanceInfo nextServerInfo = DiscoveryManager.getInstance()
//                  .getDiscoveryClient()
//                  .getNextServerFromEureka("a-bootiful-client", false);
//   int serverPort = nextServerInfo.getPort();
//   System.out.println("Found service at port:" + serverPort);
//   String result = new RestTemplate().getForObject("http://"+nextServerInfo.getHostName()+":"+nextServerInfo.getPort()+"/greeting/sayHi",String.class);
//   System.out.println("Service result with DiscoveryManager round robin = " + result);
   
//   GreetingClient greetingClient = context.getBean(GreetingClient.class);
//   System.out.println("Service result using feign = " + greetingClient.greeting());
   context.close();
 }
}

package hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableConfigurationProperties(UriConfiguration.class)
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);   
    }

    // curl --dump-header - --header "Host: www.impatient.com" http://localhost:8080/delay/3
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder,UriConfiguration uriConfiguration) {
    	String httpUri = uriConfiguration.getHttpbin();
        return builder.routes()
            .route(p -> p
                .path("/get")
                .filters(f -> f.addRequestHeader("Hello", "World"))
                //.uri("http://localhost:9092/greeting"))
                //.uri("http://localhost:8080/secondURL"))
                .uri("http://httpbin.org:80"))
            .route(p -> p
                    .host("*.impatient.com")
                    .filters(f -> f.hystrix(config -> config.setFallbackUri("forward:/fallback")))
                    .uri("http://httpbin.org:80"))
                .build();
    }

    @RequestMapping("/fallback")
    public String fallbackMessage()
    {
     return "Sorry, service is out of service";	
    }

    
    @RequestMapping("/secondURL")
    public String secondURL()
    {
     return "Hello From Second URL Service";	
    }
}


@ConfigurationProperties
class UriConfiguration {

    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}

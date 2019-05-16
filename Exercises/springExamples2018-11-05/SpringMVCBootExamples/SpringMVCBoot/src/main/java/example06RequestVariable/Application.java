package example06RequestVariable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
@RequestMapping("/example")
class ExampleController {

	
    @RequestMapping(value="/test")
    public String showExample(@RequestHeader(value="Accept") String value ) // User-Agent
    {
        return new String("Request Header Value: " + value); 
    }
    

}
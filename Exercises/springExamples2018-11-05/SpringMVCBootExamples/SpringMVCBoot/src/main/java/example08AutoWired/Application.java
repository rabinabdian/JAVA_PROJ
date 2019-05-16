package example08AutoWired;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Service 
class HelloService
{
	String getGreeting(String name, String browser) { return "Hello there " + name + " you are using " + browser ; }
}

@RestController
@RequestMapping("/example")
class ExampleController {
	
	@Autowired HttpServletRequest httpServletRequest;
	@Autowired HelloService helloService;

    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String showExample(@RequestParam(value="name", defaultValue="World") String name) {
        String userAgent = httpServletRequest.getHeaders("User-Agent").nextElement();
		return new String(helloService.getGreeting(name,userAgent)); 
    }
    

}
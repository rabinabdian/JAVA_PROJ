package example10RestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class Person
{
	Person() {}
	public String name;
	public int age;
}

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
@RequestMapping("/example")
class ExampleController {

    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String showExample(@RequestParam(value="name", defaultValue="World") String name) {
        return new String("Hello " + name); 
    }
    
    @RequestMapping(value="/getPerson",method=RequestMethod.GET)
    public Person showExample2(@RequestParam(value="name", defaultValue="World") String name) {
    	Person p = new Person(); p.name = "Dave"; p.age=12;
        return p; 
    }

    

}
package example02ReturnObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

class Person {
	String name;
	int age;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

@RestController
@RequestMapping("/example")
class ExampleController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	Person showExample(@RequestParam(value = "name", defaultValue = "NoName") String name) {
		Person p = new Person(); p.name = name;	p.age = 30;
		return p;
	}

}
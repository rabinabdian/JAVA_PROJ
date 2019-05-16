package example07ResponseEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<Person> showExample(@RequestParam(value = "name",required=false) String name) {
		if ( name == null )
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		Person p = new Person(); p.name = name;	p.age = 30;
		return new ResponseEntity<Person>(p,HttpStatus.OK);
	}

}
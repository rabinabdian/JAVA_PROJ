package example03Post;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class PersonName
{
	String firstName;
	String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
class Person
{
	String name;
	int age;
	public String getName() { return name; }
	public int getAge() { return age; }
}
@RestController
@RequestMapping("/example")
public class ExampleController {

	//C:\Gonen\progs\curl-7.61.1-win64-mingw\bin>curl --data name="abc" http://localhost:8080/example/test
	@RequestMapping(value="/test",method=RequestMethod.POST)
    Person showExample(@RequestParam(value="name", defaultValue="NoName") String name) {
    	Person p = new Person(); p.name = name; p.age = 30;
        return p;
    }
	
    //C:\Gonen\progs\curl-7.61.1-win64-mingw\bin>curl -i -H "Content-Type:application/json" -X POST --data "{"""firstName""":"""Gonen""","""lastName""":"""Israeli"""}" http://localhost:8080/example/test2
    //@PostMapping("/test2")
    @RequestMapping(value="/test2",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Person> showExample2(@RequestBody PersonName personName  ) {
    	Person p = new Person(); p.name = personName.firstName + " " + personName.lastName; p.age = 30;    	
		return new ResponseEntity<Person>(p,HttpStatus.OK);
    }


}
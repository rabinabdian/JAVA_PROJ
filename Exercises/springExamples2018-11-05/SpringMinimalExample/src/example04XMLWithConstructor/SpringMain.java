package example04XMLWithConstructor;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import minimalExample.Person;



public class SpringMain {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext4.xml");
        Person person = (Person) appContext.getBean("thePerson");
		System.out.println("Person's name = " + person.name);

     }
}

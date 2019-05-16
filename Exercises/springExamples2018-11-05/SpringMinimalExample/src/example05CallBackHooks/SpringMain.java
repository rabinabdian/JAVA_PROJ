package example05CallBackHooks;
import java.io.IOException;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import minimalExample.Person;



public class SpringMain {
    public static void main(String[] args) throws IOException {
        FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext5.xml");
        Person person = (Person) appContext.getBean("thePerson");
		System.out.println("Person's name = " + person.name);
		appContext.registerShutdownHook();

     }
}

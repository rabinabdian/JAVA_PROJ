package example02BeanWithRef;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import minimalExample.Person;



public class SpringMain {
    public static void main(String[] args) {
       FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext2.xml");
       Person person = appContext.getBean(Person.class);
       System.out.println("City = " + person.address.city);
       Person person2 = appContext.getBean(Person.class);
       System.out.println(person.address);
       System.out.println(person2.address);

     }
}

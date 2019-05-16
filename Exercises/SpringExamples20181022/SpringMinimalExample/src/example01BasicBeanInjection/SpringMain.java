package example01BasicBeanInjection;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringMain {
    public static void main(String[] args) {
       FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext1.xml");
       System.out.println(appContext.getBean("thePerson"));
       System.out.println(appContext.getBean(minimalExample.Person.class));
       appContext.close();
     }
}

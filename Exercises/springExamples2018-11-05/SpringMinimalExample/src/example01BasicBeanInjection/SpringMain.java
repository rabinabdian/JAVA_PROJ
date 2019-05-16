package example01BasicBeanInjection;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import minimalExample.Person;

public class SpringMain {
    public static void main(String[] args) {
       FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext1.xml");
       System.out.println(appContext.getBean(minimalExample.Person.class));
       System.out.println(appContext.getBean(minimalExample.Person.class));
       System.out.println(new Person());
       appContext.close();
     }
}

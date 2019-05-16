package example06SingletonFactoryMethod;
import java.io.IOException;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import minimalExample.Log;
import minimalExample.Person;



public class SpringMain {
    public static void main(String[] args) throws IOException {
        FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext6.xml");
        Log log = (Log) appContext.getBean("theLog");
        System.out.println(log);
        System.out.println(Log.getInstance());

     }
}

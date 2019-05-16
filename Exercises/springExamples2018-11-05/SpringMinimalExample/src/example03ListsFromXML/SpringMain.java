package example03ListsFromXML;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import minimalExample.Person;



public class SpringMain {
    public static void main(String[] args) {
       FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("SpringContext3.xml");
       List<String> userNameList = (List<String>) appContext.getBean("userNameList");
       userNameList.forEach(e->System.out.println(e));

     }
}

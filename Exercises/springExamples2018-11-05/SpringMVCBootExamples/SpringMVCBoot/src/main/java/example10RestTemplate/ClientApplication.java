package example10RestTemplate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

public class ClientApplication {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Gonen");
        String result;

        result = restTemplate.getForObject("http://localhost:8080/example/test", String.class);
        System.out.println("String Web service with params result = " + result);

        
        result = restTemplate.getForObject("http://localhost:8080/example/test?name={name}", String.class,params);
        System.out.println("String Web service with params result = " + result);
        
        
        Person personResult = restTemplate.getForObject("http://localhost:8080/example/getPerson", Person.class);
        System.out.println("Person Web service result = name:" + personResult.name + " age:" + personResult.age);
    }
}


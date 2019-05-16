package hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

public class DemoServiceClient {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://localhost:8080/get?name=bob", String.class);
		System.out.println("Response from service was: " + result);

	}

}

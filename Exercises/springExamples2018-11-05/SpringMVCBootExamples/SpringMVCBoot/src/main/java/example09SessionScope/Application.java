package example09SessionScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class Application {

	@SessionScope
	@Bean
	ShoppingCart getCart()
	{
		return new ShoppingCart();
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


class ShoppingCart
{
	double total;
}


@Controller
@RequestMapping("/example")
class ExampleController {
	
	@Autowired ConfigurableApplicationContext context;

    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody public String showExample(@RequestParam(value="name", defaultValue="World") String name) {
    	ShoppingCart cart = context.getBean(ShoppingCart.class);
		return "Hello " + name + "  your total is " + cart.total++; 
    }
    

}
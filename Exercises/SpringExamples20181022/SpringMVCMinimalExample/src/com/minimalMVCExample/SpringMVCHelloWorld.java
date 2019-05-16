package com.minimalMVCExample;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class SpringMVCHelloWorld {
 
	@Autowired
	Person person;
	
	@RequestMapping("/welcome")  // mapps http://localhost/SpringMVCMinimalExample/welcome
	public ModelAndView helloWorld() {
 
		String message = "<br><div><h3>Hello There " + person.firstName + " </h3></div><br><br>";
		ModelAndView model = new ModelAndView("welcome");  // Will be mapped to welcome.jsp
		model.addObject("message", message);
		return model;
	}
	
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		model.addObject("message", "Hi there " + name);

		return model;

	}
}
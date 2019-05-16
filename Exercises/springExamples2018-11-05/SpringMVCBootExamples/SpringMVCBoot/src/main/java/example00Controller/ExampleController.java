package example00Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/example")
public class ExampleController {

    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody public String showExample(@RequestParam(value="name", defaultValue="World") String name) {
        return new String("Hello " + name); 
    }
    
    @RequestMapping(value="/test2",method=RequestMethod.GET)
    @ResponseBody public String showExample2(@RequestParam(value="name", defaultValue="World") String name, HttpServletRequest request) {
        return new String("Hello " + request.getParameter("name")); 
    }

}
package example05PathVariable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @RequestMapping(value="/test/id/{id}/name/{name}")
    public String showExample(@PathVariable("id") int  id, @PathVariable("name")  String name) {
        return new String("Hello user " + name + " with id " + id); 
    }
    

}
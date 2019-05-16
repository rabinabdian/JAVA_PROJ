package example11JUnitController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ExampleController.class})
@AutoConfigureMockMvc
public class Application {

	@Autowired MockMvc mockMvc;
    @Test
    public void test1() throws Exception{
    	mockMvc.perform(get("/example/test")).andExpect(status().isOk()).andExpect(content().string(containsString("Hello World")));
   }
    
}




@RestController
@RequestMapping("/example")
class ExampleController {

    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String showExample(@RequestParam(value="name", defaultValue="World") String name) {
        return new String("Hello " ); 
    }
    

}
package testSpringBoot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanghao on 2016/12/8.
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/index/{name}")
    @ResponseBody
    public String index(@PathVariable String name){

        if(null==name){
            name="boy";
        }

        return "hello world" +name;
    }

}

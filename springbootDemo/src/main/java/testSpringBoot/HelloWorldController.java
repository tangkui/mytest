package testSpringBoot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tanghao on 2016/12/8.
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "/index/{name}",method = RequestMethod.GET,produces="application/json; charset=UTF-8")
    @ResponseBody
    public String index(@PathVariable String name){

        if(null==name){
            name="boy";
        }

        return "hello world" +name;
    }

}

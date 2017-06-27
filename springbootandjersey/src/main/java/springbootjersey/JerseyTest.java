package springbootjersey;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by tanghao on 2017/3/10.
 */
@Path("/")
@Component
public class JerseyTest {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(JerseyTest.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public Map<String,Object> hello(){

    Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","1");
        map.put("codeMsg","success");
        return map;
    }
}

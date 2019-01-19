package springbootjersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by tanghao on 2017/3/10.
 */
public class JerseyConfigBase extends ResourceConfig {

    public JerseyConfigBase(){
        register(RequestContextFilter.class);
        //配置restful package
        packages("springbootjersey");
    }
}

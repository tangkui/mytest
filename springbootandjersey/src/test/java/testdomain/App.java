package testdomain;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import springbootjersey.JerseyConfigBase;

/**
 * Created by tanghao on 2017/3/10.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Bean
    public ServletRegistrationBean jerseyServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ServletContainer(),"/*");
        registrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfigBase.class.getName());
        return registrationBean;
    }
}

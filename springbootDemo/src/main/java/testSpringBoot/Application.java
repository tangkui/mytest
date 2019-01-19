package testSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by tanghao on 2016/12/8.
 */
//@SpringBootApplication相当于@Configuration、@EnableAutoConfiguration和  @ComponentScan
//@ServletComponentScan添加Servlet注解扫描
@SpringBootApplication
@ServletComponentScan
public class Application {
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}

package testSpringTagDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tanghao on 2016/12/12.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User)context.getBean("user");
        System.out.print(user.getUserName() + user.getEmail());
    }
}

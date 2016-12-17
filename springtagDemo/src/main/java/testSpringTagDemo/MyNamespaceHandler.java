package testSpringTagDemo;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by tanghao on 2016/12/12.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}

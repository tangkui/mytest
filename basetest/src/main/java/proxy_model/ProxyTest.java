package proxy_model;


/**
 * Created by tanghao on 2017/3/16.
 */
public class ProxyTest {



    public static void main(String[] args) throws Throwable {
//            Class<?> c1 = Proxy.getProxyClass(ProxyTest.class.getClassLoader(),UserService.class);
//            final Constructor<?> constructor = c1.getConstructor(InvocationHandler.class);
//            final InvocationHandler ih = new MyInvocationHandlerDemo(new UserServiceImpl());
//            UserService userService = (UserService) constructor.newInstance(ih);
//            userService.add();
        MyInvocationHandlerDemo myIh = new MyInvocationHandlerDemo();
        UserService userService = (UserService)myIh.getProxy(new UserServiceImpl());
        userService.add();
    }
}

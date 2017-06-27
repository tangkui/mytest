package dynamicProxy;

/**
 * Created by tanghao on 2017/3/16.
 */
public class DoCglib {

    public static void main(String[] args) {
        DynamicProxy_cglib proxy_cglib = new DynamicProxy_cglib();

        SayHello sayHello = (SayHello)proxy_cglib.getProxy(SayHello.class);
        sayHello.say();
    }
}

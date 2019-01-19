package reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tanghao on 2017/3/8.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object obj = null;

    public Object bind(Object obj){
        this.obj=obj;
         Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
        return proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------before---------------");
        Object temp = method.invoke(this.obj,args);
        System.out.println("---------------after---------------");
        return temp;
    }

}

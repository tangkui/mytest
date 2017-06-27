package proxy_model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tanghao on 2017/3/16.
 */
public class MyInvocationHandlerDemo implements InvocationHandler {

    private Object target = null;


    public Object getProxy(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------------------before------------------");
        Object result = method.invoke(this.target,args);
        System.out.println("-------------------after------------------");
        return result;
    }
}

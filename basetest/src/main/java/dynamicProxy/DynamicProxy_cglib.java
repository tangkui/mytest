package dynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tanghao on 2017/3/16.
 */
public class DynamicProxy_cglib implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置需要创建的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }



    //实现MethodInterceptor接口的方法
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理。。。");
        //通过代理类调用父类中的方法
        Object result=  methodProxy.invokeSuper(o,objects);
        System.out.println("后置代理。。。");
        return result;
    }
}

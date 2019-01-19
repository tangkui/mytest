package reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by tanghao on 2017/3/7.
 * 通过发射调用某个类的方法
 */
public class ReflexTest6 {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> c1 = Class.forName("reflex.ReflexTest6");
        Method method = c1.getMethod("test1");
        method.invoke(c1.newInstance());
        method = c1.getMethod("test2");
        method.invoke(c1.newInstance());
        method = c1.getMethod("test3",String.class,int.class);
        method.invoke(c1.newInstance(),"th",20);
    }

    public void test1(){
        System.out.println("JAVA 反射机制-调用某个类的方法1");
    }
    public void test2(){
        System.out.println("JAVA 反射机制-调用某个类的方法2");
    }

    public void test3(String name,int age){
        System.out.println("JAVA 反射机制-调用某个类的方法3");
        System.out.println("name:"+name+",age:"+age);
    }
}

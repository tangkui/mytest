package reflex;

/**
 * Created by tanghao on 2017/3/8.
 */
public class ReflexTest8 {

    public static void main(String[] args) {


        /**
         * 在JAVA中有三种类加载器。
         *
         * 1）BootStrap ClassLoader 此加载器采用 C++ 编写，一般开发中很少见。
         *
         * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jrelibext目录中的类
         *
         * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java默认的加载器
         *
         * 如果想要完成动态代理，首先要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
         *
         */

        MyInvocationHandler demo = new MyInvocationHandler();
        Subject subject = (Subject)demo.bind(new RealSubject());
        subject.say("Rollen",20);
        subject.say2();
    }
}

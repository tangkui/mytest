package reflex;

/**
 * Created by tanghao on 2017/3/8.
 * JAVA反射机制
 * 获取类加载器
 */
public class RealSubject implements Subject {

    public void say(String name, int age) {
        System.out.println( name + "   "+age);
    }
    public void say2(){
        System.out.println("-----------test------------");
    }

}

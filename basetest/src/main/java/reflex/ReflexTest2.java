package reflex;

import org.w3c.dom.events.Event;

import java.io.Serializable;

/**
 * Created by tanghao on 2017/3/6.
 */
public class ReflexTest2 implements Serializable {
    private static final long serialVersionUID = 4647571441144086606L;


    public static void main(String[] args) throws Exception{
        Class<?> c1 = Class.forName("reflex.ReflexTest2");

        System.out.println("类名："+c1.getName());

        // 取得父类
        Class<?> parentClass  = c1.getSuperclass();

        System.out.println("父类名称："+parentClass.getName());

        //获得该类实现的所有接口
        Class<?> intes[] = c1.getInterfaces();

        System.out.println("该类实现的所有接口有：");

        for(int i=0;i<intes.length;i++){
            System.out.println(intes[i].getName());
        }



    }
}

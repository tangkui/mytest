package reflex;

import java.lang.reflect.Field;

/**
 * Created by tanghao on 2017/3/8.
 * JAVA反射机制操作某个类的属性
 */
public class ReflexTest7 {

    private String property = null;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> c1 = Class.forName("reflex.ReflexTest7");
        Object obj = c1.newInstance();
        //可以直接对private的属性赋值
        Field field = c1.getDeclaredField("property");
        field.setAccessible(true);//操作private属性时必须设置此项
        field.set(obj,"JAVA反射机制操作某个类的属性");
        System.out.println(field.get(obj));
    }
}

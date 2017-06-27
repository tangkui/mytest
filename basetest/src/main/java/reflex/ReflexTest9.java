package reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanghao on 2017/3/9.
 * 在泛型为Integer的ArrayList中存放一个String类型的对象。
 */
public class ReflexTest9 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        try {
            Method method = list.getClass().getMethod("add",Object.class);
            method.invoke(list,"Java反射机制实例");
            System.out.println(list.get(0));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

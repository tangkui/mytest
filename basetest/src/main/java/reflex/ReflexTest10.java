package reflex;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by tanghao on 2017/3/9.
 *
 * 通过反射取得并修改数组的信息
 *
 */
public class ReflexTest10 {

    public static void main(String[] args) {
        int[] temp = {1,2,3,4,5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型："+demo.getName());
        System.out.println("数组长度："+ Array.getLength(temp));
        System.out.println("数组的第一个元素"+Array.get(temp,0));
        System.out.println("修改之前的数组："+ Arrays.toString(temp));
        Array.set(temp,0,100);
        System.out.println("修改后的数组的第一个元素："+Array.get(temp,0));
        System.out.println("修改后的数组："+Arrays.toString(temp));
     }
}

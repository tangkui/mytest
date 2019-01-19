package reflex;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by tanghao on 2017/3/6.
 * 获取类的属性
 */
public class ReflexTest4 extends User implements Serializable {
    private static final long serialVersionUID = 6842906422664954891L;
    public String str;


    public static void main(String[] args) throws ClassNotFoundException {

        //获取类名
        Class<?> c1 = Class.forName("reflex.ReflexTest4");
        System.out.println("类命："+c1.getName());
        //获取类的全部属性（不包括超类）
        Field[] fields = c1.getDeclaredFields();
        for(int i = 0;i<fields.length;i++){
            //权限修饰符
            int mo = fields[i].getModifiers();
            String priv = Modifier.toString(mo);
            System.out.println("权限修饰符Int值："+mo);
            System.out.println("转换后的权限修饰符String值："+priv);
            //属性类型
            Class<?> type =  fields[i].getType();
            String typeName = type.getName();
            System.out.println("属性类型："+typeName);
            //属性名称
            String name = fields[i].getName();//取该类所有属性名称，没有权限的限制，不包括继承。
            System.out.println(priv + " " + typeName + " " + name + ";");

        }

        //实现的接口或者父类的属性

        System.out.println("实现的接口或者父类的属性");
        //实现的接口
        Class<?> c2[] = c1.getInterfaces();
        for(int j = 0;j<c2.length;j++){
            System.out.println("实现的接口：："+c2[j].getName());
            System.out.println("取出来是啥："+c2[j].getClass());//接口不是类，所以此处取出来的是指向Class<?>类型的java.lang.Class

        }
        //获取该类的全部属性（包括继承的类，比如超类）
        Field field[] = c1.getFields();
        for(int k = 0;k<field.length;k++){
            System.out.println("----:"+field[k].getName());//取该类和父类的所有public修饰的属性名称，注意：只能取public修饰的属性名称
            // 权限修饰符
            int b = field[k].getModifiers();
            System.out.println("权限修饰符2："+b);
            String strb = Modifier.toString(b);
            System.out.println("转换后的权限修饰符2："+strb);
            // 属性类型
            Class<?> classes = field[k].getType();
            System.out.println("属性类型2:"+classes.getName());
        }





    }
}

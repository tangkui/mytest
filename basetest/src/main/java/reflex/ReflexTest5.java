package reflex;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by tanghao on 2017/3/7.
 * 获得该类的对象的所有方法
 */
public class ReflexTest5 implements Serializable {
    private static final long serialVersionUID = 8021084598916300021L;


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("reflex.ReflexTest5");
        Method[] methods = c1.getMethods();
        for(int i = 0;i<methods.length;i++){
            //方法名称
            System.out.println("方法名称："+methods[i].getName());
            //方法返回类型
            System.out.println("方法返回类型："+methods[i].getReturnType().getName());
            //方法修饰符
            int a = methods[i].getModifiers();
            String modifersStr = Modifier.toString(a);
            System.out.println("方法修饰符int："+a);
            System.out.println("方法修饰符String："+modifersStr);
            ReflexTest5 reflexTest5 = new ReflexTest5();
            //方法参数
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            for(int j = 0;j<parameterTypes.length;j++){
                //方法参数类型
                System.out.println("方法参数类型："+parameterTypes[j].getName());
            }
            //方法的异常
            Class<?> c3[] = methods[i].getExceptionTypes();
            for(int k=0;k<c3.length;k++){
                System.out.println("异常类型："+c3[k].getName());
            }
        }
    }
}

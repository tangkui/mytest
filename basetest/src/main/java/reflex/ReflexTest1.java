package reflex;

/**
 * Created by tanghao on 2017/3/6.
 */
public class ReflexTest1 {

    //实例化Class对象
    public static void main(String[] args) throws ClassNotFoundException {

        //Class c1 = null;
        Class<?> c1 = null;
        Class<?> c2 = null;
        Class<?> c3 = null;

        c1 = Class.forName("reflex.ReflexTest1");

        c2 = new ReflexTest1().getClass();

        c3 = ReflexTest1.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());

    }
}

package reflex;

/**
 * Created by tanghao on 2017/3/6.
 * 反射
 */
public class ReflexTest {

    //通过一个对象获得完整的包名和类名
    public static void main(String[] args) {

        ReflexTest reflexTest = new ReflexTest();
        System.out.println(reflexTest.getClass());//class reflex.ReflexTest  获得类
        System.out.println(reflexTest.getClass().getName());//reflex.ReflexTest  获得类名

    }

}

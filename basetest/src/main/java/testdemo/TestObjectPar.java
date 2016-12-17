package testdemo;

/**
 * Created by tanghao on 2016/12/16.
 */
public class TestObjectPar {


    public static void main(String[] args) {
        testObj(new Integer(10),new String("10"),new Object());
    }

    public static void testObj(Object ... args){

        System.out.println(args.length);
    }

}

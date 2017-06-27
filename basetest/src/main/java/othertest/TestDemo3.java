package othertest;

/**
 * Created by tanghao on 2017/5/1.
 */
public class TestDemo3 {

    String str = new String("good");

    char[] ch = { 'a', 'b', 'c' };
    public static void main(String[] args) {
        TestDemo3 ex = new TestDemo3();

        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and ");

        System.out.print(ex.ch);
    }


    public void change(String str, char ch[]) {

        str = "test ok";

        ch[0] = 'g';

    }
}

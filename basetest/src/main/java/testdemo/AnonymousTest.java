package testdemo;

/**
 * Created by tanghao on 2017/3/6.
 * 匿名内部类
 */
public class AnonymousTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                for(int i=1;i<=5;i++){
                    System.out.println(i);
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }
}

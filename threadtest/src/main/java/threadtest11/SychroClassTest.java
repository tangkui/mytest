package threadtest11;

/**
 * Created by tanghao on 2017/3/2.
 */
public class SychroClassTest implements Runnable {

    private static int count;

    public SychroClassTest() {
        count=0;
    }

    public static void method(){
        synchronized (SychroClassTest.class){
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+":"+(count++));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void run() {
        method();
    }

    public static void main(String[] args) {
        SychroClassTest s1 = new SychroClassTest();
        SychroClassTest s2 = new SychroClassTest();
        Thread thread1 = new Thread(s1,"Thread1");
        Thread thread2 = new Thread(s2,"Thread2");

        thread1.start();
        thread2.start();
    }
}

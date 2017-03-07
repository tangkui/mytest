package threadtest10;

/**
 * Created by tanghao on 2017/3/2.
 */
public class SynchroStaticTest implements Runnable {

    private static int count;
//syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2并发执行时却保持了线程同步。
// 这是因为run中调用了静态方法method，而静态方法是属于类的，所以syncThread1和syncThread2相当于用了同一把锁。这与Demo1是不同的。

    public SynchroStaticTest() {
        count=0;
    }

    public synchronized static void method(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"："+(count++));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        method();
    }

    public static void main(String[] args) {
        SynchroStaticTest s1 = new SynchroStaticTest();
        SynchroStaticTest s2 = new SynchroStaticTest();
        Thread thread1 = new Thread(s1,"Thread1");
        Thread thread2 = new Thread(s2,"Thread2");
        thread1.start();
        thread2.start();
    }
}

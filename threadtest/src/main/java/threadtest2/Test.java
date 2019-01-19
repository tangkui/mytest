package threadtest2;

/**
 * Created by tanghao on 2017/3/1.
 * 线程的实现方式以及启动
 */
public class Test {

    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
//      Thread(Runnable target) 分配新的 Thread 对象。
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        thread1.run();
        thread2.run();
        thread1.start();
        thread2.start();
    }
}

class Runner1 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner1运行状态——————————" + i);
        }
    }
}

class Runner2 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner2运行状态==========" + i);
        }
    }
}

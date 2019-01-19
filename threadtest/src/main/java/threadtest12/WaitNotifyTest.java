package threadtest12;

import javax.swing.tree.RowMapper;

/**
 * Created by tanghao on 2017/3/2.
 */
public class WaitNotifyTest {


    //一个测试类，交付创建多个等待线程和一个通过线程，并启动这些线程。


    public static void main(String[] args) {

        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1,"waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier,"notifier").start();

        System.out.println("All the Threads are started");

    }
}

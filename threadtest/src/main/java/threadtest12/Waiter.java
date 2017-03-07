package threadtest12;

/**
 * Created by tanghao on 2017/3/2.
 */
public class Waiter implements Runnable {


    //一个Waiter类，等待其它的线程调用notify方法以唤醒线程完成处理。注意等待线程必须通过加synchronized同步锁拥有Message对象的监视器。


    private Message msg;


    public Waiter(Message msg) {
        this.msg = msg;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        synchronized(msg){
            try {
                //在等待通知的时间
                System.out.println(name+":waiting to get notified ai time:"+System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //等待线程获得通知的时间
            System.out.println(name+":waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+":processed:"+msg.getMsg());

        }
    }
}

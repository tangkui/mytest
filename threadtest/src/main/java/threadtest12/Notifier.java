package threadtest12;

/**
 * Created by tanghao on 2017/3/2.
 */
public class Notifier implements Runnable {
    //一个Notifier类，处理Message对象并调用notify方法唤醒等待Message对象的线程。注意synchronized代码块被用于持有Message对象的监视器。

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name+":Started");
        try {
            Thread.sleep(1000);
            synchronized(msg){
                msg.setMsg(name+":Notifiter work done");
                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

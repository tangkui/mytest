package threadtest6;

/**
 * Created by tanghao on 2017/3/1.
 * 线程优先级
 */
public class PriorityThread implements Runnable{

  //  Java中通过getPriority和setPriority方法获取和设置线程的优先级。Thread类提供了三个表示优先级的常量：MIN_PRIORITY优先级最低，为1；NORM_PRIORITY是正常的优先级；为5，MAX_PRIORITY优先级最高，为10。我们创建线程对象后，如果不显示的设
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("当前线程名字："+Thread.currentThread().getName()+"##当前线程优先级："+Thread.currentThread().getPriority());
        }
    }

    public static void main(String[] args) {
        //创建三个线程
        Thread thread1 = new Thread(new PriorityThread(),"Thread1");
        Thread thread2 = new Thread(new PriorityThread(),"Thread2");
        Thread thread3 = new Thread(new PriorityThread(),"Thread3");

        //设置优先级
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(8);
        //开始执行线程
        thread3.start();
        thread2.start();
        thread1.start();
    }
}

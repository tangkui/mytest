package threadtest4;

import threadtest1.ThreadA;

/**
 * Created by tanghao on 2017/3/1.
 * 打印线程
 * 线程中断
 */
public class Printer implements Runnable {


//    public void interrupt(); 中断线程。
//    public static boolean interrupted(); 是一个静态方法，用于测试当前线程是否已经中断，并将线程的中断状态 清除。所以如果线程已经中断，调用两次interrupted，第二次时会返回false，因为第一次返回true后会清除中断状态。
//    public boolean isInterrupted(); 测试线程是否已经中断。

    public void  run() {

        //public boolean isInterrupted(); 测试线程是否已经中断。
        System.out.println("当前线程状态"+Thread.currentThread().isInterrupted());//线程被打断返回ture，未被打断返回ture
        while(!Thread.currentThread().isInterrupted()){ //如果当前线程未被打断（ture），则执行打印工作
            System.out.println(Thread.currentThread().getName()+"打印中... ...");
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println("interrupted:"+Thread.interrupted());//返回当前线程的状态，并清除状态 已经中断返回ture，未被中断返回false
            System.out.println("isinterrupted:"+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer,"打印线程");
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("有紧急任务出现，需中断打印线程.");
        System.out.println("中断前的状态1：" + thread.isInterrupted());
        System.out.println("当前的状态2：" + thread.currentThread().isInterrupted());
        thread.interrupt();       // 中断打印线程
        System.out.println("中断前的状态3：" + thread.isInterrupted());
    }
}

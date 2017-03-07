package threadtest1;

/**
 * Created by tanghao on 2017/3/1.
 */
public class ThreadA implements Runnable {
    private Thread thread;
    private String threadName;

    public ThreadA(String threadName){
        thread = new Thread(this,threadName);
        this.threadName=threadName;
    }

    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(threadName + ": " + i);
        }
    }

    public void start(){
        thread.start();
    }


}

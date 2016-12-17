package testdemo;

/**
 * Created by tanghao on 2016/12/15.
 */
public class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
        for(int i = 4;i>0;i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            Thread.sleep(50);
        }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }

    public void start (){
        System.out.println("Starting " +  threadName );
        if(t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }

    public Thread getT() {
        return t;
    }

    public void setT(Thread t) {
        this.t = t;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}

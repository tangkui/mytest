package threadtest13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tanghao on 2017/3/4.
 */
public class FixedThreadPool {

    public static List<Double> queue;
    public ExecutorService threadPool;

    public FixedThreadPool(){
        queue=new ArrayList<Double>();
        //产生一个ExecutorService对象，这个对象带有一个poolSize的线程池，若任务数量大于poolSize，任务会被放在一个queue里面顺序执行。
        threadPool = Executors.newFixedThreadPool(5);
    }

    public static void main(String[] args){
        FixedThreadPool outer = new FixedThreadPool();
        FixedThreadPool.Manager inner = outer.new Manager();
        Thread consumer = new Thread(inner);

        Thread producer = new Thread(){//用于向queue中放入数据

            public void run(){
                while(true){
                    synchronized (queue){
                        double time = 1d;
                        long starttime = System.currentTimeMillis();
                        if(System.currentTimeMillis()-starttime >= time){
                            starttime = System.currentTimeMillis();
                            for(int i = 0;i<10;i++){
                                queue.add((Math.random() * 10000));
                            }
                            queue.notify();
                        }
                    }
                }
            }
        };
        consumer.start();
        producer.start();

    }

    class Manager implements Runnable {
        int num = 0;
        public void run() {
            while (true) {
                try {
                    synchronized (queue) {
                        System.out.println("队列的长度为:" + queue.size());
                        while (queue.isEmpty()) {
                            queue.wait();
                        }
                        double result = queue.remove(0);
                        num++;
                        System.out.println("成功从队列中取到数据！" + num);
                        threadPool.execute(new ExecutorThread(result));
                    }
                } catch (InterruptedException t) {
                    break;
                }
            }
            threadPool.shutdown();
        }
    }

    class ExecutorThread implements Runnable{

        private double value;

        public ExecutorThread(double value) {
            this.value = value;
        }

        public void run() {
            System.out.println("This is "+Thread.currentThread().getName()+" "+value);
        }
    }
}

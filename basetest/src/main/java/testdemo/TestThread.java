package testdemo;

/**
 * Created by tanghao on 2016/12/15.
 */
public class TestThread {

    public static void main(String[] args) {
//        RunnableDemo r1 = new RunnableDemo("Thread-1");
//        r1.start();
//        RunnableDemo r2 = new RunnableDemo("Thread-2");
//        r2.start();

        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();

    }
}

package threadtest5;

/**
 * Created by tanghao on 2017/3/1.
 * 线程合并
 */
public class PluginInstallStart {

    public static void main(String[] args) {


//        public final void join()
//        等待该线程终止
//
//        public final void join(long millis);
//        等待该线程终止的时间最长为 millis 毫秒。超时为 0 意味着要一直等下去。
//
//        public final void join(long millis, int nanos)
//        等待该线程终止的时间最长为 millis 毫秒 + nanos 纳秒

        Plugin1 plugin1 = new Plugin1();
        Plugin2 plugin2 = new Plugin2();

        Thread thread1 = new Thread(plugin1);
        Thread thread2 = new Thread(plugin2);

        System.out.println("主线程开启...");
        try {
            thread1.start();    //开始插件1的安装
            thread1.join();     //等待插件1的安装线程结束
            thread2.start();    //插件2开始安装
            thread2.join();     //等待插件2的安装线程结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束，程序安装完成！");
    }
}

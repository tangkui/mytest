package threadtest5;

/**
 * Created by tanghao on 2017/3/1.
 * 插件2
 */
public class Plugin2 implements Runnable {

    public void run() {
        System.out.println("插件2开始安装");
        System.out.println("插件2安装中...");
        System.out.println("插件2安装完成！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

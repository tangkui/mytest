package threadtest5;

/**
 * Created by tanghao on 2017/3/1.
 * 插件1
 */
public class Plugin1 implements Runnable{

    public void run() {
        System.out.println("插件1开始安装");
        System.out.println("插件1安装中...");
        System.out.println("插件1安装完成！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

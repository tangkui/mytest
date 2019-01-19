package threadtest3;

/**
 * Created by tanghao on 2017/3/1.
 * 多线程模拟售票
 */
public class TicketingSystem {

    public static void main(String[] args) {
        Service service = new Service("北京-->台北",100);
        TicketSaler ticketSaler = new TicketSaler("售票程序",service);
        //创建八个线程，模拟8个端口
        Thread threads[] = new Thread[8];
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(ticketSaler,"窗口"+(i+1));
            System.out.println("窗口" + (i + 1) + "开始出售 " + service.getTicketName() + " 的票...");
            threads[i].start();
        }

    }
}

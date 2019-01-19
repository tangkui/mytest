package threadtest3;

/**
 * Created by tanghao on 2017/3/1.
 */
public class TicketSaler implements Runnable {
    private String name;
    private Service service;

    public TicketSaler(String name, Service service) {
        this.name = name;
        this.service = service;
    }

    public void run() {
        while(service.getRemaining()>0){
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+"第"+service.getRemaining()+"张票");
                int remaining = service.saleTicket(1);
                if(remaining>0){
                    System.out.println("出票成功，剩余"+remaining+"张票");
                }else{
                    System.out.println("出票失败，该票已售完。");
                }
            }
        }
    }
}

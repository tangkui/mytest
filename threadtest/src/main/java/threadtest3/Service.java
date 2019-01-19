package threadtest3;

/**
 * Created by tanghao on 2017/3/1.
 *
 */
public class Service {

    private String ticketName;//票名
    private int totalCount;//总票数
    private int remaining;//剩余票数

    public Service(String ticketName,int totalCount){
        this.ticketName=ticketName;
        this.totalCount=totalCount;
        this.remaining=totalCount;
    }

    public synchronized int saleTicket(int  ticketNum){
        if(remaining>0){
        //remaining-=ticketNum;
        remaining = remaining-ticketNum;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(remaining>=0){
                return remaining;
            }else{
                remaining = remaining+ticketNum;
                return -1;
            }
        }
        return -1;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}

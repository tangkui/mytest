package threadtest9;

/**
 * Created by tanghao on 2017/3/2.
 * 银行账户类
 */
public class Account {
    private String name;
    private float amout;


    public Account(String name, Float amout) {
        this.name = name;
        this.amout = amout;
    }

    //存钱
    public void deposit(float amt){
     amout+= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //取钱
    public void withdraw(float amt){
        amout-=amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAmout() {
        return amout;
    }

    public void setAmout(Float amout) {
        this.amout = amout;
    }
}

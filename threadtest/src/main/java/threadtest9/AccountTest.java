package threadtest9;

/**
 * Created by tanghao on 2017/3/2.
 */
public class AccountTest {

    private static final int THREAD_NUM=5;

    public static void main(String[] args) {
        Account account = new Account("zhang san",1000.0f);
        AccountOperator accountOperator = new AccountOperator(account);
        Thread thread[]=new Thread[THREAD_NUM];
        for(int i=0;i<thread.length;i++){
            thread[i]=new Thread(accountOperator,"Thread"+i);
            thread[i].start();
        }
    }
}

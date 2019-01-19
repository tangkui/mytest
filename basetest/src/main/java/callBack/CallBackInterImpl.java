package callBack;

/**
 * Created by tanghao on 2017/3/16.
 */
public class CallBackInterImpl implements CallBackInter {

    public static void main(String[] args) {
        CallBackDemo callBackDemo = new CallBackDemo();
        callBackDemo.doSomething(new CallBackInterImpl());
    }


    public void setCallBack() {
        System.out.println("回掉函数");
    }
}

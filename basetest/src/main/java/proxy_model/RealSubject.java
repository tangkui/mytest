package proxy_model;

/**
 * Created by tanghao on 2017/3/9.
 * 真实角色：实现了Subject的request方法
 */
public class RealSubject extends Subject {


    public RealSubject() {

    }

    public void request() {
        System.out.println("真实对象RealSubject");
    }
}

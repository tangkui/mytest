package proxy_model;

/**
 * Created by tanghao on 2017/3/9.
 * 代理角色
 *
 */
public class ProxyModelTest extends Subject {

    //以真实角色作为代理角色的属性
    private RealSubject realSubject;

    public ProxyModelTest() {
    }

    public void request() {


        before();

        if(realSubject==null){
            realSubject = new RealSubject();
        }

        realSubject.request();

        after();
    }

    public void before(){
        System.out.println("++++++++++++代理对象执行真实对象操作之前++++++++++++");
    }

    public void after(){
        System.out.println("++++++++++++代理对象执行真实对象操作之后++++++++++++");
    }

    public static void main(String[] args) {
        Subject subject = new ProxyModelTest();
        subject.request();
    }
}

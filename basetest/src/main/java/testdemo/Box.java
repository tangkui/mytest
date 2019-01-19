package testdemo;

/**
 * Created by tanghao on 2016/12/14.
 */
public class Box<T> {

    private T t;

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String>  stringBox = new Box<String>();
        integerBox.setT(new Integer(10));
        stringBox.setT(new String("TH"));
        System.out.println(integerBox.getT());
        System.out.println(stringBox.getT());
    }




    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

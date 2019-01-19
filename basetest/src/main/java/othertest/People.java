package othertest;

/**
 * Created by tanghao on 2017/5/1.
 */
public class People {

    String name;

    public People() {
        System.out.print(1);
    }

    public People(String name) {
        System.out.print(2);
        this.name = name;
    }
}

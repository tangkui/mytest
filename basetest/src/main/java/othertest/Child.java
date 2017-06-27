package othertest;

/**
 * Created by tanghao on 2017/5/1.
 */
public class Child extends People {

    People father;

    public Child(String name) {
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }

    public Child() {
        System.out.print(4);
    }

    public static void main(String[] args) {
        System.out.println(new Child("mike"));
    }

}

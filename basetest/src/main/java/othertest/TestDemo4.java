package othertest;

/**
 * Created by tanghao on 2017/5/1.
 */
public class TestDemo4 {

    public static void main(String[] args) {
        getValue(2);
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        System.out.println(result);
        return result;
    }
}

package testdemo;

/**
 * Created by tanghao on 2016/12/14.
 */
public class MaximumTest {

    public static void main(String[] args) {
        System.out.println(maximum(1,2,3));
        System.out.println(maximum(1.1,2.2,3.3));
        System.out.println(maximum("1","2","3"));

    }

    public static <T extends Comparable<T>> T maximum(T x,T y,T z){
        T max = x;// 假设x是初始最大值
        if(y.compareTo(max)>0){
            max = y;
        }

        if(z.compareTo(max)>0){
            max = z;
        }
        return max;
    }
}

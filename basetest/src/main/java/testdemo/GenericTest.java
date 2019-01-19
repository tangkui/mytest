package testdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanghao on 2016/12/14.
 */
public class GenericTest {

    public static void main(String[] args) {
        List<String> str = new ArrayList<String>();
        List<Number> num = new ArrayList<Number>();
        List<Integer> integers = new ArrayList<Integer>();
        str.add("cn");
        str.add("th");
        num.add(1234);
        integers.add(1);
        getData(str);
        getData(num);
        getData(integers);
        getnumData(num);
        getnumData(integers);
    }

    public static void getData(List<?> data){
        System.out.println(data);
        System.out.println(data.get(0));
    }

    public static void getnumData(List<? extends Number> data){
        System.out.println(data.get(0));
    }
}

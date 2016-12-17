package testdemo;

/**
 * Created by tanghao on 2016/12/14.
 */
public class GenericMethodTest {


    public static void main(String[] args) {
        Integer [] intArray  = {1,2,3,4,5};
        printArray(intArray);

        Double [] doubleArray = {1.1,1.2,1.3,1.4,1.5};
        printArray(doubleArray);

        Character [] charArray = {'A','B','C','D','E'};
        printArray(charArray);
    }

    public static <E> void printArray(E [] inputArray ){
        //输出元素数组
        for(E element:inputArray){
            System.out.printf( "%s ", element );
        }
    }
}

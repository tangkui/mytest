package reflex;

import java.lang.reflect.Array;

/**
 * Created by tanghao on 2017/3/9.
 */
public class ReflexTest11 {

    public static void main(String[] args) {
        //原数组
        int[] temp = {1,2,3,4,5,6,7,8,9};
        //新数组
        int[] newTemp = (int[])arrayInc(temp,5);
        //输出数组内容
        print(newTemp);

        String[] strArr = {"a","b","c","d","e","f","g","h"};
        String[] newArr = (String[])arrayInc(strArr,5);
        print(newArr);
    }

    /**
     * 修改数组的大小
     * @param obj
     * @param len
     * @return
     */
    public static Object arrayInc(Object obj,int len){
        System.out.println("arrayInc原数组长度："+Array.getLength(obj));
        //获得数组类型
        Class<?> arr = obj.getClass().getComponentType();
        System.out.println("arrayInc原数组类型："+arr.getName());
        //实例化一个arr类型长度为len的新数组
        Object newArr = Array.newInstance(arr,len);//一个int类型的长度为15的新数组 int[] newArray = new int[15];
        Class<?> newClass = newArr.getClass().getComponentType();
        System.out.println("arrayInc新数组类型："+newClass.getName());
        //获得新数组长度
        int co = Array.getLength(newArr);
        System.out.println("arrayInc新数组的长度："+co);
        //复制数组
        System.arraycopy(obj,0,newArr,0,co);
        //返回新的数组
        return newArr;
    }

    /**
     * 打印数组
     * @param obj
     */
    public static void print(Object obj){
        Class<?> c = obj.getClass();
        if(!c.isArray()){
            return;
        }
        System.out.println("print新数组长度为"+Array.getLength(obj));

        for(int i = 0;i<Array.getLength(obj);i++){
            System.out.println("print新数组["+i+"]："+Array.get(obj,i));
        }
    }


}

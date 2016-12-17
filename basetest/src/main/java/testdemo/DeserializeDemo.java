package testdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by tanghao on 2016/12/15.
 */
public class DeserializeDemo {

    public static void main(String[] args) {
        Employee employee = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\tanghao\\Desktop\\/employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            employee = (Employee)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(employee.getName());
        System.out.println(employee.getAddress());
        System.out.println(employee.getNumber());
        System.out.println(employee.getSSN());//当对象被序列化时，属性 SSN 的值为 111222333，但是因为该属性是短暂的，该值没有被发送到输出流。所以反序列化后 Employee 对象的 SSN 属性为 0。
    }
}

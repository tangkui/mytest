package testdemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by tanghao on 2016/12/15.
 */
public class SerializeDemo {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "Reyan Ali";
        employee.address = "Phokka Kuan, Ambehta Peer";
        employee.SSN = 11122333;
        employee.number = 101;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\tanghao\\Desktop\\/employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

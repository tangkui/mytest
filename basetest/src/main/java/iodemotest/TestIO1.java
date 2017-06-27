package iodemotest;

import java.io.*;

/**
 * Created by tanghao on 2017/3/10.
 */
public class TestIO1 {

    public static void main(String[] args) throws IOException {
        //1.以行为单位从一个文件读取数据
        Reader reader = new InputStreamReader(new FileInputStream("C:\\Users\\tanghao\\Desktop\\/0303学习.txt"), "gbk");
        BufferedReader  bufferedReader = new BufferedReader(reader);
        String s = new String();
        String s2 = new String();
        while((s2=bufferedReader.readLine())!=null){
            s = s+s2+"\n";
        }
        System.out.println(s);
        bufferedReader.close();
        reader.close();
    }
}

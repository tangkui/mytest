package iodemotest;

import java.io.*;

/**
 * Created by tanghao on 2017/3/11.
 */
public class TestIO2 {

    public static void main(String[] args) throws IOException {
        //写一行数据到文件并保存到桌面
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\tanghao\\Desktop\\/testIO2.txt"),"GBK");
        outputStreamWriter.write("what does fox say?");
        outputStreamWriter.close();
    }
}

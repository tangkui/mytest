package testdomain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by tanghao on 2017/3/10.
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"utf-8");
    }
}

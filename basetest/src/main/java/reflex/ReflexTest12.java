package reflex;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tanghao on 2017/3/9.
 * 反射机制应用于工厂模式
 */
public class ReflexTest12 {


    public static void main(String[] args) throws Exception {
        ReflexTest12 reflexTest12 = new ReflexTest12();
        String value = reflexTest12.getPropertyData("apple");
        System.out.println("value:"+value);
        Fruit fruit = FruitFactory.getInstance(value);
      //Fruit fruit = FruitFactory.getInstance("reflex.Apple");
        if(fruit!=null){//apple="reflex.Apple"
            fruit.eat();
        }
    }


    public String getPropertyData(String keyName) throws IOException {
        System.out.println("配置文件参数属性："+keyName);
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);
        String value =  properties.getProperty(keyName);
        System.out.println("配置文件参数值："+value);
        return value;
    }


}

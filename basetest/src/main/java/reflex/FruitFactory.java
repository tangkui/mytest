package reflex;

/**
 * Created by tanghao on 2017/3/9.
 */
public class FruitFactory {


    public static Fruit getInstance(String className) throws Exception {
        Fruit fruit = null;
        if(className==null||"".equals(className)){
                throw new Exception("className is "+className);
        }
        return fruit = (Fruit) Class.forName(className).newInstance();
    }
}

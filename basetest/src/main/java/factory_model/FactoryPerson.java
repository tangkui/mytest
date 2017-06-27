package factory_model;

/**
 * Created by tanghao on 2017/3/10.
 */
public class FactoryPerson {

    static Object object = null;

    public static Object getNewInstance(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> c1Name = Class.forName(name);
        object = c1Name.newInstance();
        return object;
     }
}

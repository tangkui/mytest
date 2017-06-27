package factory_model;

/**
 * Created by tanghao on 2017/3/10.
 */
public class FatoryModelTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Person person = (Person) FactoryPerson.getNewInstance("factory_model.Chinese");
        person.love();
    }
}

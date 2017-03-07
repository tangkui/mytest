package jacksontestDemo;

import domain.AccountBean;
import domain.Birthday;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanghao on 2017/2/23.
 */
public class ReadAccountTest {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            AccountBean bean = objectMapper.readValue(new File("C:\\Users\\tanghao\\Desktop\\account.json"),AccountBean.class);
            System.out.println(bean.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static <T> List<T> jsonToList(String jsonStr,Class<?> collectionClass, Class<?>... elementClasses)
            throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass,elementClasses);
        String jsonstr = "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"
                + "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";

        return mapper.readValue(jsonstr,javaType);
    }
}

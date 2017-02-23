package jacksontestDemo;

import domain.AccountBean;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

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
}

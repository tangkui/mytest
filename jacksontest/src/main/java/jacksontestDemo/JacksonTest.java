package jacksontestDemo;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import domain.AccountBean;
import domain.Birthday;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/**
 * Created by tanghao on 2017/2/22.
 */
public class JacksonTest {

    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    private AccountBean bean = null;
    private Birthday birthday = null;
    @Before
    public void init() {
        bean = new AccountBean();
        birthday = new Birthday("1205");
        bean.setAddress("js_wuxi");
        bean.setEmail("bugyun@hotmail.com");
        bean.setId(1);
        bean.setName("bugyun");
        bean.setBirthday(birthday);
        objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory() {
        try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            bean = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @description: JavaBean(Entity/Model)转换成JSON
     *      上面分别利用JsonGenerator的writeObject方法和ObjectMapper的writeValue方法完成对Java对象的转换，二者传递的参数及构造的方式不同；
     *      JsonGenerator的创建依赖于ObjectMapper对象。
     *      也就是说如果你要使用JsonGenerator来转换JSON，那么你必须创建一个ObjectMapper。
     *      但是你用ObjectMapper来转换JSON，则不需要JSONGenerator。objectMapper的writeValue方法可以将一个Java对象转换成JSON。
     *      这个方法的参数一，需要提供一个输出流，转换后可以通过这个流来输出转换后的内容。
     *      或是提供一个File，将转换后的内容写入到File中。当然，这个参数也可以接收一个JSONGenerator，然后通过JSONGenerator来输出转换后的信息。
     *      第二个参数是将要被转换的Java对象。如果用三个参数的方法，那么是一个Config。
     *      这个config可以提供一些转换时的规则，过指定的Java对象的某些属性进行过滤或转换等。
     *
     *      输出：
     *          jsonGenerator   {"id":1,"name":"bugyun","email":"bugyun@hotmail.com","address":"js_wuxi","birthday":null}
     *          ObjectMapper    {"id":1,"name":"bugyun","email":"bugyun@hotmail.com","address":"js_wuxi","birthday":null}
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月24日上午11:34:53
     */
    @Test
    public void writeEntityJSON() {
        try {
            System.out.println("jsonGenerator");
            jsonGenerator.writeObject(bean);
            JsonNodeFactory factory = new JsonNodeFactory(false);
            System.out.println("\nObjectMapper");
            objectMapper.writeValue(System.out, bean);
            this.objectMapper.writeValue(new File("C:\\Users\\tanghao\\Desktop\\account.json"),bean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**
     * @description: 将Map集合转换成Json字符串
     *      输出：
     *          jsonGenerator   {"name":"bugyun","account":{"id":1,"name":"bugyun","email":"bugyun@hotmail.com","address":"js_wuxi","birthday":null}}
     *          ObjectMapper    {"name":"bugyun","account":{"id":1,"name":"bugyun","email":"bugyun@hotmail.com","address":"js_wuxi","birthday":null}}
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月24日上午11:41:48
     */
    @Test
    public void writeMapJSON() {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", bean.getName());
            map.put("account", bean);

            System.out.println("jsonGenerator");
            jsonGenerator.writeObject(map);

            System.out.println("\n ObjectMapper");
            objectMapper.writeValue(System.out, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @description: 将List集合转换成json
     *  外面就是多了个[]中括号；同样Array也可以转换，转换的JSON和上面的结果是一样的
     *    输出：
     *      jsonGenerator   [{"id":1,"name":"bugyun","email":"bugyun@hotmail.com","address":"js_wuxi","birthday":null}]
     *      ObjectMapper    1###[{"id":1,"name":"bugyun","email":"bugyun@hotmail.com","address":"js_wuxi","birthday":null}]
     *                      2###[{"id":1,"name":"bugyun","email":"bugyun@hotmail.com","address":"js_wuxi","birthday":null}]
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月24日上午11:46:41
     */
    @Test
    public void writeListJSON() {
        try {
            List<AccountBean> list = new ArrayList<AccountBean>();
            list.add(bean);

            System.out.println("jsonGenerator");
            jsonGenerator.writeObject(list);

            System.out.println("\nObjectMapper");
            System.out.println("1###" + objectMapper.writeValueAsString(list));

            System.out.print("2###");
            objectMapper.writeValue(System.out, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @description: 复杂的Java类型的JSON转换
     *      输出：
     *          {"user":{"name":"jackson","sex":true,"age":22},"infos":[22,"this is array"]}
     *          {"user":{"id":1,"name":"haha","email":"email","address":"address","birthday":null},"infos":["a","b","c"]}
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月24日下午1:08:06
     */
    @Test
    public void writeOthersJSON() {
        try {
            String[] arr = { "a", "b", "c" };
            //Object
            jsonGenerator.writeStartObject();//{
            jsonGenerator.writeObjectFieldStart("user");//user:{
            jsonGenerator.writeStringField("name", "jackson");//name:jackson
            jsonGenerator.writeBooleanField("sex", true);//sex:true
            jsonGenerator.writeNumberField("age", 22);//age:22
            jsonGenerator.writeEndObject();//}

            jsonGenerator.writeArrayFieldStart("infos");//infos:[
            jsonGenerator.writeNumber(22);//22
            jsonGenerator.writeString("this is array");//this is array
            jsonGenerator.writeEndArray();//]

            jsonGenerator.writeEndObject();//}

//          ********************************************
            AccountBean bean = new AccountBean();
            bean.setAddress("address");
            bean.setEmail("email");
            bean.setId(1);
            bean.setName("haha");
            jsonGenerator.writeStartObject();//{
            jsonGenerator.writeObjectField("user", bean);//user:{bean}
            jsonGenerator.writeObjectField("infos", arr);//infos:[array]
            jsonGenerator.writeEndObject();//}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @description: 将json字符串转换成JavaBean对象
     *      用到了ObjectMapper这个对象的readValue这个方法，这个方法需要提供2个参数。
     *      第一个参数就是解析的JSON字符串，
     *      第二个参数是将这个JSON解析持什么Java对象，Java对象的类型。当然，还有其他相同签名方法。
     *
     *      输出：
     *          haha
     *          haha#1#address#null#email
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月24日下午3:37:50
     */
    @Test
    public void readJson2Entity() {
        String json = "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}";
        try {
            AccountBean acc = objectMapper.readValue(json, AccountBean.class);
            System.out.println(acc.getName());
            System.out.println(acc);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @description: json字符串转换成list<map>
     *      输出：
     *          address:address2
     *          name:haha2
     *          id:2
     *          email:email2
     *          address:address
     *          name:haha
     *          id:1
     *          email:email
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月25日下午4:39:39
     */
    @Test
    public void readJson2List() {
        String json = "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"
                + "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";
        try {
            List<Map<String, Object>> list = objectMapper.readValue(json, List.class);
//          System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                Set<String> set = map.keySet();
                for (Iterator it = set.iterator(); it.hasNext();) {
                    String key = (String) it.next();
                    System.out.println(key + ":" + map.get(key));
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @description: json字符串转换成Array
     *      输出：
     *          haha2#2#address2#null#email2
     *          haha#1#address#null#email
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月25日下午4:44:09
     */
    @Test
    public void readJson2Array() {
        String json = "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"
                + "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";
        try {
            AccountBean[] arr = objectMapper.readValue(json, AccountBean[].class);
//          System.out.println(arr.length);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @description: json字符串转换Map集合
     *      输出：
     *          success:true
     *          A:{address=address2, name=haha2, id=2, email=email2}
     *          B:{address=address, name=haha, id=1, email=email}
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月25日下午4:48:40
     */
    @Test
    public void readJson2Map() {
        String json = "{\"success\":true,\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"
                + "\"B\":{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}}";
        try {
            Map<String, Map<String, Object>> maps = objectMapper.readValue(json, Map.class);
//          System.out.println(maps.size());
            Set<String> key = maps.keySet();
            Iterator<String> iter = key.iterator();
            while (iter.hasNext()) {
                String field = iter.next();
                System.out.println(field + ":" + maps.get(field));
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * @description: java Object 转换为 xml
     *      输出：
     *          <ArrayList xmlns=""><item><id>1</id><name>bugyun</name><email>bugyun@hotmail.com</email><address>js_wuxi</address><birthday/></item></ArrayList>
     *          <HashMap xmlns=""><A><id>1</id><name>bugyun</name><email>bugyun@hotmail.com</email><address>js_wuxi</address><birthday/></A></HashMap>
     * @return void
     * @throws
     * @author beyond
     * @data:2016年2月26日上午9:20:49
     */
    @Test
    public void writeObject2Xml() {
        XmlMapper xml = new XmlMapper();

        try {
            //javaBean转换成xml
            //xml.writeValue(System.out, bean);
            StringWriter sw = new StringWriter();
            xml.writeValue(sw, bean);
//          System.out.println(sw.toString());
//          List转换成xml
            List<AccountBean> list = new ArrayList<AccountBean>();
            list.add(bean);
            System.out.println(xml.writeValueAsString(list));

//          Map转换xml文档
            Map<String, AccountBean> map = new HashMap<String, AccountBean>();
            map.put("A", bean);
            System.out.println(xml.writeValueAsString(map));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

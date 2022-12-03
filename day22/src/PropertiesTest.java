import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 用来读取配置文件
 * 常用来处理配置文件。key和vaLue都是String类型，也是集合。
 * @author zzy
 * @date 2022-10-17 08:38
 */
public class PropertiesTest {
    @Test
    public void test1(){
        FileInputStream fis = null;
        try {
            Properties pro = new Properties();
            //默认的路径在当前的Module下
            fis = new FileInputStream("jdbc.properties");
            pro.load(fis);//加载流对应的文件

            String name = pro.getProperty("name");
            String password = pro.getProperty("password");
            System.out.println(name + "***"+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

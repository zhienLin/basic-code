package www.itheima;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zzy
 * @date 2022-10-17 08:18
 */
public class ClassLoaderExer {
    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderExer.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getparent():获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2 );//null

        //引导类加载器确实没有办法获取到
        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);//null

    }


    //读取配置文件

    @Test
    public void test2() throws IOException {

        //读取配置文件的方式一：
        //此前的文件默认在当前的module下
        Properties pro = new Properties();
/*        FileInputStream fis = new FileInputStream("jbdc.properties");
        pro.load(fis);
        String name = pro.getProperty("name");
        String age = pro.getProperty("age");
        System.out.println(name +"--"+age);*/

        //读取配置文件的方式二：ClassLoader类
        //此时的文件默认在当前module的src下
        ClassLoader classLoader = ClassLoaderExer.class.getClassLoader();
        //获取一个输入流
        InputStream resourceAsStream = classLoader.getResourceAsStream("www/itheima/jdbc1.properties");
        pro.load(resourceAsStream);
        String name = pro.getProperty("name");
        String age = pro.getProperty("age");
        System.out.println(name +"--"+age);

    }







}



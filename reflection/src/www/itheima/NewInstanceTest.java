package www.itheima;

import org.junit.Test;

import java.util.Random;

/**
 * @author zzy
 * @date 2022-10-17 09:52
 */
public class NewInstanceTest {
    /*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器
        要想此方法正常的创建运行时类的对象，要求:
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public。

        在javabean中要求提供一个public的空参构造器。
        原因:1.便于通过反射，创建运行时类的对象。
             2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        //第一个抛出的异常是权限修饰符带来的
        //第二个抛出的异常是空参构造器带来的
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();//默认调用的就是空参的构造器
        System.out.println(person);

    }

    //体会反射的动态性
    @Test
    public void test2(){
        String s = "";
        for (int i = 0; i < 100; i++) {
            int random = new Random().nextInt(3);
            switch (random){
                case 0 :  s = "java.util.Date";
                break;
                case 1 :  s = "java.lang.Object";
                break;
                case 2 :  s = "Person";
                break;
            }

            try {
                System.out.println(getInstance(s));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public Object getInstance (String s) throws Exception{
        Class aClass = Class.forName(s);
        return aClass.newInstance();
    }


}

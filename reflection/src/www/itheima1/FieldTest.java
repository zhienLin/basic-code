package www.itheima1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 其他的获取方法也是一样的，declared****和****区别是一样的
 * @author zzy
 * @date 2022-10-17 11:23
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //只能获取当前类及其父类的public的属性
        Field[] fields = personClass.getFields();
        for (Field df : fields){
            System.out.println(df);
        }

        //getDeclaredFields()可以得到Person声明的每一个属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field df : declaredFields) {

            //1.获取属性对应的权限修饰符
            int modifiers = df.getModifiers();
            //System.out.println(modifiers);
            // modifiers对应的是一个又一个的整数，
            // 通过调用Modifier.toString(int)的方法，才能获取当前的权限修饰符
            System.out.print(Modifier.toString(modifiers)+"    ");

            //2.数据类型
            Class<?> type = df.getType();
            System.out.print(type+"    ");

            //3.变量名
            String name = df.getName();
            System.out.println(name);

        }

    }
}

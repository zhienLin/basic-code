package www.itheima1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zzy
 * @date 2022-10-17 16:53
 */
public class GetWay {

    //如何获得运行时类中指定的属性 --- 需要掌握
    @Test
    public void testField() throws Exception {
        Class<Person> personClass = Person.class;
        //1.创建运行时类的对象
        Person person = personClass.newInstance();
        //2.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");
        //3.保证当前属性是可访问的
        name.setAccessible(true);
        //4.获取、设置指定对象的此属性值
        name.set(person,"东霓");
        System.out.println(name.get(person));
    }


    //如何获得运行时类中指定的方法 --- 需要掌握
    @Test
    public void testMethod() throws Exception {
        Class<Person> personClass = Person.class;
        //1.创建运行时类的对象
        Person person = personClass.newInstance();
        //2.getDeclaredMethod(String fieldName):
        //参数1:指明获取的方法的名称  参数2:指明获取的方法的形参列表
        Method show = personClass.getDeclaredMethod("show",int.class);
        //3.保证当前方法是可访问的
        show.setAccessible(true);
        //4.调用方法的invoke(): 参数1:方法的调用者 参数2:给方法形参赋值的实参
        //invoke()的返回值即为对应类中调用的方法的返回值。
        Object returnValue = show.invoke(person, 19);
        System.out.println(returnValue);

        System.out.println("如何获取静态的方法");
        Method verify = personClass.getDeclaredMethod("verify", char.class);
        verify.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        //Object a = verify.invoke(personClass, 'a');
        Object a = verify.invoke(null, 'a');
        //对于静态的方，哪怕这里没有写明他的第一个参数，也是可以运行的，
        //因为invoke是verify这个对象调用的，而verify本身就是personClass的一个对象，
        //那就本身就已经知道静态方法的所属类了，就算没有写也没有问题
        System.out.println(a);


    }
}

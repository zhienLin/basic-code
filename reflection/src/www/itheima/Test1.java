package www.itheima;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 1.通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个?
 * 直接new的方式
 * 什么时候会使用反射的方式呢？ 动态性，就是比如服务器端向后台发送数据，但是这个时候后台已经运行了，
 * 那么收到服务器端发来的消息，我们就动态地利用反射地方法去造一个对象。
 * 2.反射的机制和之前的面向对象的封装性是不是有矛盾的啊？如何看待两个技术？
 * 不矛盾。把一些属性或者方法封装成私有的时候，代表并不建议去调用私有的方法，因为对实现某个目标并没有多大的帮助，
 * 但是反射就是，虽然我不建议你这么做，不代表你不能或者私有的属性和方法。
 *
 * 3.类的加载过程:
 * >程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
 * 接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
 * 此过程就称为类的加载。加载到内存中的类，我们就称为运行时类,此运行时类，就作为CLass的一个实例。
 * >万事万物皆对象，换句话说，Class的实例就对应着一个运行时类。
 * >3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
 *    运行时类只有一个，可以理解为一种单例的模式，我们只能获取，并非创建。
 * @author zzy
 * @date 2022-10-14 11:12
 */
public class Test1 {
    @Test
    public void testBefore() throws Exception {
        //反射之前（所有的私有化的属性、方法、构造方法都没有办法获得）
        {
            Person p1 = new Person("xixi",22);
            p1.age = 23;
            p1.show();

        }


    }
    @Test
    public void testAfter() throws NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchFieldException {
        //反射之后（所有的私有化的属性、方法、构造方法都没有办法获得）
        {
            Class pc  = Person.class;//这个是反射的源头，其实还是Person类本身

            //1.通过反射，创建Person类的对象
            Constructor constructor = pc.getConstructor(String.class, int.class);
            Object instance = constructor.newInstance("至恩", 18);
            Person p = (Person) instance;
            //这里哪怕没有进行强制转换，最后调用的toSting()的方法也是子类重写之后的，因为多态的行为就是这样的
            System.out.println(instance.toString());

            //2.通过反射，调用对象指定的属性

            Field declaredFieldAge = pc.getDeclaredField("age");
            declaredFieldAge.set(p,25);
            System.out.println(p.toString());

            //3.通过反射，调用对象指定的方法
            Method declaredMethods = pc.getDeclaredMethod("show");
            declaredMethods.invoke(p);

            //4.通过反射，可以调用Person类的私有结构的。比如:私有的构造器、方法、属性
              //*私有的构造器
                Constructor declaredConstructor = pc.getDeclaredConstructor(int.class);
                declaredConstructor.setAccessible(true);
                Person xijue = (Person) declaredConstructor.newInstance(23);
                System.out.println(xijue.toString());
            //*私有的属性
                Field declaredField = pc.getDeclaredField("name");
                declaredField.setAccessible(true);
                declaredField.set(xijue,"西决");
                System.out.println(xijue.toString());
            //*私有的方法
                Method setNation = pc.getDeclaredMethod("setNation",String.class);
                setNation.setAccessible(true);
            //相当于调用了xijue.setNation(),那么xijue.setNation()的返回值是String,同样的，下面的默认返回的是Object类型的，那就强制转换就可以了。
                String s = (String) setNation.invoke(xijue,"中国");
                //Object haha = setNation.invoke(xijue, "中国");
                System.out.println(s);
        }
    }

    @Test
    public void test() throws ClassNotFoundException {
        //方式一：调用运行时类的属性.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //方式二：调用运行时类的对象 getClass()
        Person p = new Person("xixi",19);
        Class<? extends Person> aClass = p.getClass();//这种方式就是通过对象进行调用，其实就是想看看当前的对象到底是哪个包下的

        //方式三：推荐用这种方式，因为能更好地体现动态性，在编译阶段并不会报错，只是在运行阶段才会显现
        Class<?> aClass1 = Class.forName("www.itheima.Person");


        //方式四:使用类的加载器: ClassLoader
        ClassLoader classLoader = Test1.class.getClassLoader();


        System.out.println((personClass==aClass1));//true,只有一个，因此地址值是一样的


    }

    //Class实例不光对应运行时类，也可以是下面的这些结构
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[ 100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //要元素类型与维度一样，就是同一个cLass
        System.out.println(c10 == c11);
    }



}

class Person{
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + "}";
    }

    public void show() {
        System.out.println("平凡且普通");
    }


    private void setNation(String nation) {
        System.out.println(name+"的国籍是："+nation);
    }
}
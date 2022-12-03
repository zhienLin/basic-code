package IOStream;

import org.junit.Test;

import java.io.*;

public class ObjectStream {

    @Test
    public void testOutputStream(){
        //序列化的过程
        ObjectOutputStream oot = null;
        try {
            oot = new ObjectOutputStream(new FileOutputStream("object.txt"));
            oot.writeObject("adwawd");//写入的是一个对象
            oot.flush();
            oot.writeObject(new Student("xixi",13));//写入的是一个对象
            oot.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(oot!=null)
                oot.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testInputStream(){
        //反序列化过程
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Object object1 = ois.readObject();
            System.out.println(object1);
            Student object2 = (Student)ois.readObject();
            System.out.println(object2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}


//*满足以下的要求才可以序列化：
// 1）.需要实现标识接口
// 2）.当前类提供一个全局常量: serialVersionUID
// 3）.当前类的所有属性都是可序列化的，比如属性里面定义了一个其他类的对象，那么这个其他类的对象必须是可以序列化的。

//*简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来驱证版本一致性的。
//在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID
//进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。(InvalidCastException)
//如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自动生成的。
//若类的实例变量做了修改，serialVersionUID可能发生变化。故建议，显式声明。
//就是如果没有定义这个常量，就进行序列化，一定会自动生成一个静态的常量。在首次进行反序列化的时候会根据这个常量去辨别想要恢复的类。
//但是如果类的某个属性发生了变化，可能会导致这个静态常量发生改变，那么反序列化的时候还是按照之前的序列值找，这个发生改变的二进制流就再也没有办法进行识别了。
//这个序列号是保证转换成二进制流之后，能够辨别当前传过来的到底是什么，不至于两个对象类之间发生数据的混杂。
//Serializable是一个标识接口，因为没有任何可以重写的方法，凡是实现这个接口的类都是可以实例化的。

//*被static和transient修饰的属性是没有办法进行序列化的。
/*
对象流：
ObjectInputStream和OjbectOutputSteam
用于存储和读取基术数据类型数据或对象的处理流。
它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。



对象的序列化机制：（主要作用主要是进程和进程之间的信息传输）
1、序列化：允许把内存中的java对象转换成与平台无关的二进制流的形式，
从而允许把这种二进制流永久的保存在磁盘上，或者通过网络将这种二进制流传输到另外一个网络节点。
2、反序列化：当其他的程序获得了这种二进制流，就可以恢复或者复原原来的java对象。
 */
class Student implements Serializable{
    //序列的版本号，再自定义异常时候也需要自定义异常的序列号
    public static final long serialVersionUID = 40L;
    private String name;
    private int age;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
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
        return "Student{name = " + name + ", age = " + age + "}";
    }
}



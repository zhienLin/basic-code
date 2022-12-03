package www.itheima.com.collection.List;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsClass {
    /*
    泛型：是JDK5以后引入的一个新的特性，可以做到在编译的阶段约束操作类型，进行检查
    泛型的格式：<引用数据类型>
     */

    //JDK5之前
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        //因为那个时候对类型没有限制，因此可以添加任何的数据类型
        list.add("11");
        list.add(1);
        list.add(true);

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            //因为上面没有泛型的约束，所以生成的是父类对象Object。
            //由于多态的特性，父类没有办法调用子类或者实现类的特有函数
            String next =(String) iterator.next();//class java.lang.Integer cannot be cast to class java.lang.String
            //next.length();会出现错误，而且操作起来特别的不方便，
            //因此为了发便操作，进行了泛型的约束
        }


    }
}

/*总结：
1.泛型的好处：统一了数据类型。
2.把运行时的问题提起拿到了编译期间,在编译期间就可以进行数据类型的校验，避免了强制转换可能出现的异常。
3.Java中的泛型其实是一个伪泛型，在编译的时候是String类型的，但是到了字节码class文件中，
又变成了Object类型的，在输出的时候，又变成了String类型的。这个叫做泛型的擦除
4.为什么没有根本性的改变呢？因为之前的很多版本中，都是基于没有泛型的，如果想要改变会不太容易
所以就只是增加了类似看门的功能
 */
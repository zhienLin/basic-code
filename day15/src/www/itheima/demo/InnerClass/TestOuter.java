package www.itheima.demo.InnerClass;

import www.itheima.demo.interfaceAdaptivor.Inter;

public class TestOuter {
    public static void main(String[] args) {
        //变成私有的就有问题了,因为外部类并不知道有什么内部类
        Outer.Inner oi = new Outer(). new Inner();

        //解决办法：直接子在外部类编写方法，对外提供内部类的对象。
        //然后调用方法就可以了
        Outer o = new Outer();
        //这样会报错的，因为现在Inner是一个私有的。
        //Outer.Inner instance = o.getInstance();

        //解决办法1，转换成Inner的父类，Object
        Object instance = o.getInstance();
        //解决办法2，直接打印输出
        System.out.println(o.getInstance());
        //Outer$Inner@3b6eb2ec,内部和外部的类用$分隔。
        oi.show();


    }
}

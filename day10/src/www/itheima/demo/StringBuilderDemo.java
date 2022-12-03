package www.itheima.demo;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2= new StringBuilder("abc");
        StringBuilder sb3= new StringBuilder("abc");
        StringBuilder sb4= new StringBuilder();
        StringBuilder sb5= new StringBuilder();

        System.out.print(1);
        System.out.print(sb1);
        System.out.println(2);//输出为12,中间的sb1根本就没有任何值的输出。之前我们了解到一旦新建了一个对象，通常打印的是地址值。
                             // 但是因为StringBuilder是一个已经写好的类，java的开发人员在底层对它进行了一些处理，让其打印的是
                             //属性值而不是地址值。因为刚开始创建的时候里面什么也没有，所以没有任何东西打印输出

        //1、添加元素
        sb1.append(1);
        sb1.append(2.3);
        sb1.append(true);
        System.out.println(sb1);//12.3true

        //2、反转：在容器内部直接做了反转。和字符串不一样，字符串是调用了一个函数，返回值是反转之后的值，但是原来的字符串的内容并没有发生任何的改变。
        //StringBuilder里面的可以改变。
        sb3.reverse();
        System.out.println(sb3);//cba

        //3、长度
        System.out.println(sb3.length());

        //4、变回字符串
        sb4.append("aaa");
        sb4.append("bbb");
        sb4.append("ccc");
        sb4.append("ddd");

        String s = sb4.toString();//变完字符串之后可以用任何字符串的方法
        System.out.println(s);

        //5、链式编程：相当于把方法的调动写在了一行。
        sb5.append("aaa").append("bbb").append("ccc").append("ddd");
        System.out.println(sb5);


    }
}

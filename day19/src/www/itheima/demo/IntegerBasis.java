package www.itheima.demo;

public class IntegerBasis {
    public static void main(String[] args) {
        //创建对象
        Integer i1= new Integer(123);
        Integer i2= new Integer("123");

        Integer i3= new Integer(128);
        Integer i4= new Integer("128");
        System.out.println(i3==i4);//"=="号比较的是地址值
        System.out.println(i3.equals(i4));//equals比较的是属性值


        //可以用静态的方法给对象复赋值
        Integer integer1 = Integer.valueOf(127);
        Integer integer2 = Integer.valueOf("127");
        System.out.println(integer1==integer2);//"=="号比较的是地址值，看是不是一个对象

        Integer integer3 = Integer.valueOf(128);
        Integer integer4 = Integer.valueOf("128");
        System.out.println(integer3==integer4);

        //两个对象相加的步骤：(之前的方法)
        //1.先把对象拆箱，变成基本数据类型
        //2.相加
        //3.把结果封装
        int result = integer3.intValue() + integer4.intValue();
        Integer resultInteger = new Integer(result);
        System.out.println(resultInteger);

        //但是这个太麻烦了，JDK5：自动装箱+自动拆箱

        //这个就是自动装箱。
        Integer inew = 12;
        //在底层还是调用了静态方法valueOf得到了一个Interger的对象，只不过这个动作不需要我们去操作

        //这个就是自动拆箱。
        Integer inew1 = Integer.valueOf(23);
        int a = inew1;



    }
}


//1、包装类其实就是把我们之前的基本数据类型封装成一个引用数据类型的对象
//因为在集合啊，在使用Object的一些方法的时候，基本数据类型没办法去使用。
//后面跟的对象可以是具体的整数值，也可以是字符串。

//2、valueOf和new()两者的区别：如果valueOf的值在-128~127，使用相同的数值的时候并不会创建新的对象
//这是因为-128~127用的相对来讲比较多，如果总是创建新的对象会太浪费内存了
//所以提前把这个范围里面的都创建好对象，如果用到了不会创建新的，而是返回已经创建好的值。

//3、JDK5：自动装箱+自动拆箱 （我们可以把int 和 Integer 看成是一个东西）
//自动装箱:把基本的数据类型自动变成其对应的包装类
//自动拆箱:把包装类自动变成其对应的数据类型
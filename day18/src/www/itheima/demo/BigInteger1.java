package www.itheima.demo;

import java.math.BigInteger;
import java.util.Random;

public class BigInteger1 {
    public static void main(String[] args) {
        BigIntegerCreative();
        getBigIntegerMeans();
    }

    public static void BigIntegerCreative() {
        //1.获取一个随机数
        BigInteger bd1 = new BigInteger(4, new Random());
        System.out.println(bd1);

        //2.获取一个任意大的整数，这个整数要写在后面的字符串当中
        BigInteger bd2 = new BigInteger("-99999999999999999999999999999999999999999999999999");
        System.out.println(bd2);

        //3.获取指定进制的大整数
        BigInteger bd3 = new BigInteger("300", 8);
        System.out.println(bd3);
        //细节：字符串中的数字必须是整数
        //后面的进制必须和前面的温和

        //4.用静态的方法来获取BigInteger的对象
        //1.但是这个后面的值只能是long类型的，一旦超出long的取值范围，就会报错。
        //2.在内部对常用的数字进行了优化，-16~16
        //3.提前把-16~16创建好了BigInteger的对象，如果多次获取并不会创建新的对象。
        BigInteger bd4 = BigInteger.valueOf(999999999999999999L);

        BigInteger bd5 = BigInteger.valueOf(17);
        BigInteger bd6 = BigInteger.valueOf(17);

        System.out.println(bd5 == bd6);// ==号对比的是地址值
        System.out.println(bd5.equals(bd6));//equals在这路比较是内容，详细可以去看它的底层代码


        //对象一旦创建，内部数据就不能发生改变
        BigInteger bd7 = BigInteger.valueOf(16);
        BigInteger bd8 = BigInteger.valueOf(16);
        System.out.println(bd7 == bd8);//true
        bd7 = BigInteger.valueOf(1);//这里创建了一个新的对象
        System.out.println(bd7 == bd8);//false


    }

    public static void getBigIntegerMeans() {
        BigInteger bd1 = BigInteger.valueOf(10);//-16~16之间的都可以用静态的方法
        BigInteger bd2 = BigInteger.valueOf(4);
        BigInteger add = bd1.add(bd2);
        System.out.println(add);

        BigInteger[] bigIntegers = bd1.divideAndRemainder(bd2);
        System.out.println(bigIntegers.length);

        System.out.println(bd1.equals(bd2));

        System.out.println(bd1.pow(2));

        BigInteger max = bd1.max(bd2);//这里只返回比较大的值，但是不会创建新的对象，因为改变它的值。
        System.out.println(max);
        System.out.println(max==bd1);//true
        System.out.println(max==bd2);//false

        BigInteger bd10 = BigInteger.valueOf(2147483648L);
        //int a = bd10.intValue(bd10);//超出Int的取值范围就发生了错误
        long a = bd10.longValue();
        System.out.println(a);


        /*
        bd1.add();
        bd1.subtract();
        bd1.divide();
        bd1.divideAndRemainder();//返回含有商和余数的数组
        bd1.pow();//次幂，只能接整数
        bd1.equals()//比较的属性
         */



    }
}

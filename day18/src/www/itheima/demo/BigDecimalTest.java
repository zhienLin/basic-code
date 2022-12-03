package www.itheima.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimalCreate();
        BigDecimalMethods();
    }

    public static void BigDecimalCreate() {
        //1.下面的构造方法的结果有一定的不可预知性
        BigDecimal bigDecimal1 = new BigDecimal(0.01);
        BigDecimal bigDecimal2 = new BigDecimal(0.05);
        System.out.println(bigDecimal1);//0.01000000000000000020816681711721685132943093776702880859375
        System.out.println(bigDecimal2);//0.05000000000000000277555756156289135105907917022705078125

        //2.为了防止不可预知性，我们通常可以用字符串的形式
        BigDecimal bigDecimal3 = new BigDecimal("0.01");
        BigDecimal bigDecimal4 = new BigDecimal("0.05");
        System.out.println(bigDecimal3);
        System.out.println(bigDecimal4);

        //3.通过静态方法获取对象
        BigDecimal bigDecimal6 = BigDecimal.valueOf(10);
        BigDecimal bigDecimal7 = BigDecimal.valueOf(10);
        System.out.println(bigDecimal6==bigDecimal7);//true

        //1.如果表示的数不大，没有超过doubled的取值范围，建议用静态方法
        //2.如果表示的数比较大，超过doubled的取值范围，建议用字符串的方法
        //3.如果我们传递的是0~10之间的整数，那么方法会返回已经创建好的对象，不会new,这样节约内存

        BigDecimal bigDecimal8 = BigDecimal.valueOf(10.0);
        BigDecimal bigDecimal9 = BigDecimal.valueOf(10.0);
        System.out.println(bigDecimal8==bigDecimal9);//false,因为小数都是new出来的
    }

    public static void BigDecimalMethods() {
        BigDecimal bd1 = new BigDecimal(10.0);
        BigDecimal bd2 = new BigDecimal(3.0);
        BigDecimal add = bd1.add(bd2);
        System.out.println(add);


        System.out.println(bd1.divide(bd2));//这个时候没有办法除尽，就会报错，ArithmeticException

        //在遇到除不尽的情况下，就需要用到下面的方法
        bd1.divide(bd2,2, RoundingMode.HALF_UP);

    }
}

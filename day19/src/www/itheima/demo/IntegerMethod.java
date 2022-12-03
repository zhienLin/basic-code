package www.itheima.demo;

public class IntegerMethod {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toOctalString(100));//O是8进制
        System.out.println(Integer.toHexString(100));//H是16进制


        //按字符串类型转换成int类型的整数
        //这个是最实用的
        //因为java是一种强语言类型：每种数据在java中都有各自的数据类型
        //在计算的时候不同的数据类型没有办法直接计算
        String s1 = "123";
        int i = Integer.parseInt(s1);
        System.out.println(i);

        String s2 = "true";
        Boolean.parseBoolean(s2);

    }
}
//1、
//2/8/16进制之间的转化，
//返回的是字符串类型的原因：1、二进制的开头可能会出现符号位"0",在基本数据类型中是不合规范的
//int类型最多是10位啊，如果转化成二进制可能会出现超出的情况，所以用的是字符串类型。

//2、按字符串类型转换成int类型的整数
//   在类型转换的时候。字符串只能是数字，不能是其他的，否则代码会报错
//   8中包装类中，除了Character都有对应的parseXX的方法
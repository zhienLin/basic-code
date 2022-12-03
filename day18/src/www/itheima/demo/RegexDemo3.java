package www.itheima.demo;

public class RegexDemo3 {
    public static void main(String[] args) {

        String regex1 = "\\w{4,16}";//校验用户名的
        String regex2 = "[1-9]\\d{16}(\\d|X|x)";//校验简易版的身份证号1.0
        String regex3 = "[1-9]\\d{16}[\\dXx]";//校验简易版的身份证号2.0
        String regex4 = "[1-9]\\d{16}[\\d(?i)X]";//校验简易版的身份证号3.0  忽略了大小写的方式(?i)
        //身份证号码的严格校验
        //前六位：第一位不能是0，后面5位是任意数字   [1-9]\d{5}
        //后面8位：年的前半段：18 19 20 后面半段：任意数字  (18|19|20)\\d{2}    (1[8-9]\\d{2}|20([0-1][0-9]|2[1-2]))
        //月 01 09 11 12 (0[1-9]|1[0-2])
        //日 1~31         (0[1-9]|[1-2]\\d|3[01])
        //后面4位 前三位是任意数字，最后一位可以是Xx \\d{3}[\\dXx]
        String regex5 = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[01])\\d{3}[\\dXx]";
        String regex6 ="[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|10|11|12)(0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]";

        System.out.println("130225199811085529".matches(regex6));




/*
        System.out.println("zahngsan".matches(regex1));
        System.out.println("lisi".matches(regex1));
        System.out.println("hah@".matches(regex1));

        System.out.println("130225199811085529".matches(regex3));
        System.out.println("13022519981108552x".matches(regex3));
        System.out.println("030225199811085529".matches(regex3));*/


    }
}

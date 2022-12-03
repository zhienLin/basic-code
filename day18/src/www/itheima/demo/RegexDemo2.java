package www.itheima.demo;

public class RegexDemo2 {
    /*
    1.用户的手机号码
    2.用户的邮箱号码
    3.用户的座机号码
    */
    public static void main(String[] args) {
        String phoneNum="19818957911";
        String tablePhoneNum="020-2324267";
        String emaliNum="840222408@qq.com";

        String regexPhone = "1[3-9]\\d{9}";
        String regexTablePhone = "0\\d{2,3}-?[1-9]\\d{4,9}";
        //出现一次或者两次的的可以用小括号括起来，然后可以出现几次在后面标明
        String regexEmail = "\\w+@[\\w&&[^_]]{2,6}(.[a-zA-Z]{2,3}){1,2}";

        System.out.println(phoneNum.matches(regexPhone));
        System.out.println(emaliNum.matches(regexEmail));
        System.out.println(tablePhoneNum.matches(regexTablePhone));

        //24小时
        String regex ="([01]\\d|2[0-3])(:[0-5]\\d){2}";
        System.out.println("23:11:11".matches(regex));


    }




}

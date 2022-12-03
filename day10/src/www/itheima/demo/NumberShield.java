package www.itheima.demo;

import java.util.Scanner;

public class NumberShield {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入您的手机号:");
        String phonenumber = s.next();

        //老师交给的快捷函数
        String short1 = phonenumber.substring(0, 3);//带有两个参数的就是截取从0-2索引的值
        String short2 = phonenumber.substring(7);//带有一个参数的就是截取从索引7截取到末尾
        String shortmid = "****";
        String shilenum = short1 + shortmid + short2;
        System.out.print("被屏蔽之后的号码是："+ shilenum);


        //自己选取的方法
        /*String shieldnumber = shield(phonenumber);
        System.out.println();
        System.out.print("被屏蔽之后的号码是："+ shieldnumber);*/

    }
    /*public static  String shield (String phonenumber){
        String s = "";
        for (int i = 0; i < 3; i++) {
            s =  s + phonenumber.charAt(i);
        }
        for (int i = 3; i < 7; i++) {
            s = s+ "*";
        }
        for (int i = 7; i < phonenumber.length(); i++) {
            s = s + phonenumber.charAt(i);
        }
        return s;
    }*/
}
//phonenumber.substring(0, 3);//带有两个参数的就是截取从0-2索引的值。
//phonenumber.substring(7);//带有一个参数的就是截取从索引7截取到末尾。
//并且以上的两个都是方法，返回的是截取之后的，但是对字符串本身没有什么影响。
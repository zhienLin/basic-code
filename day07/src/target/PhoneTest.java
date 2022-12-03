package target;

import org.w3c.dom.ls.LSOutput;

public class PhoneTest {
    public static void main(String[] args) {
        //创建手机对象
        Phone p = new Phone();

        //给手机赋值
        p.setBrand("小米");
        p.setPrice(12345);

        //获取手机对象中的值
        System.out.println(p.setBrand());
        System.out.println(p.setPrice());

        //调用手机中的方法
        p.call();
        p.playGame();


        //========================================
        p.method();


    }


}

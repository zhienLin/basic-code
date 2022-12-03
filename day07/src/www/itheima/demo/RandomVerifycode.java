package www.itheima.demo;

import java.util.Random;

/*定义方法实现随机产生一个5位的验证码
格式：长度为5 前四位是大写或者小写字母 最后一位是数字*/
public class RandomVerifycode {
    public static void main(String[] args) {
        //自己调用的方法的输出
/*        System.out.print("随机的验证码是：");
        getVerifyCode();*/
        //================================================
        //被启发之下的方法的输出
        getVerifyCode1();

    }

    //自己定义的方法
    /*public static void getVerifyCode() {
        Random r = new Random();
        for (int i = 1; i < 5; i++) {
            System.out.print(getBS());
        }
        System.out.print(r.nextInt(10));
    }*/
    //自己定义的方法所包含的函数
    /*public static char getBS() {
        Random r = new Random();
        char letter;
        int a = r.nextInt(2);
        if (a == 0)
            letter = (char) (r.nextInt(26) + 65);
        else
            letter = (char) (r.nextInt(26) + 97);
        return letter;
    }*/


    //被启发之下的方法
    public static String getVerifyCode1() {
        //把所有随机数定义在一个数组里面
        String result = "";
        char[] random1 = new char[62];
        for (int i = 0; i < random1.length; i++) {
            if (i < 26)
                random1[i] = (char) (65 + i);
            else if (26 <= i && i < 52)
                random1[i] = (char) (97 + i - 26);
            else
                random1[i] = (char) (48 + i - 52);
        }

        //创建随机对象
        Random r = new Random();
        for (int i = 1; i < 5; i++) {
            result = result + random1[r.nextInt(52)];
        }
        result = result + random1[r.nextInt(10)+52];
        System.out.println(result);
        return result;
    }


}

//以后遇到这种随机的问题，有一种编程的小技巧，那就是把所有随机的值放在一个数组里面
//然后对数组进行随机的索引。


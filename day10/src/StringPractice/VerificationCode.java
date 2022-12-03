package StringPractice;
/*
生成验证码
内容:可以是小写字母，也可以是大写字母，还可以是数字规则;
长度为5
内容中是四位字母，1位数字。
其中数字只有1位，但是可以出现在任意的位置。*/

import java.util.Random;

public class VerificationCode {
    public static void main(String[] args) {

        Random r = new Random();
        //定义验证码取值的数组
        char [] word = new char[52];
        char [] num = new char[10];
        char [] verificationCode = new char[5];
        //大写
        for (int i = 0; i < 26; i++) {
            word[i]= (char)('A'+i);
        }
        //小写
        for (int i = 26; i < word.length; i++) {
            word[i]= (char)('a'+i - 26);
        }
        //数字
        for (int i = 0; i < num.length; i++) {
            num[i]= (char)('0'+i);
        }

        //先假定前4个是大小写的
        for (int i = 0; i < 4; i++) {
            verificationCode[i] = word[r.nextInt(52)];
        }
        //最后一个是数字
        verificationCode[4] = num[r.nextInt(10)];

        //打乱混顺序
        for (int i = 0; i < 5; i++) {
            int a = r.nextInt(5);
            char temp;
            temp = verificationCode[i];
            verificationCode[i] = verificationCode[a];
            verificationCode[a] = temp;
        }

        String s = new String(verificationCode);
        System.out.println("验证码为："+s);

    }

}

package www.itheima.demo;

import java.util.Scanner;

public class CountString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个字符：");
        String s1 = s.next();
        int big = 0;
        int small = 0;
        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z')
                small++;
            else if (s1.charAt(i) >= 'A' && s1.charAt(i) <= 'Z')
                big++;
            else if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9')
                num++;
        }

        System.out.println("大写字母的个数是："+ big);
        System.out.println("小写字母的个数是："+ small);
        System.out.println("数字的个数是："+ num);


    }
}

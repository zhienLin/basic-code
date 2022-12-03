package www.itheima.demo;

import java.util.Scanner;

//数组的长度就是 数组名.length ,但是字符串的长度是 字符串对象.length().它调用的是一个函数
public class InputString {
    public static void main(String[] args) {
        //键盘录入一个字符串
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个字符串:");
        String s1 = s.next();

        //进行遍历
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            System.out.print(c);

        }
    }
}

package www.itheima.demo;

import com.sun.source.tree.NewArrayTree;

import java.util.Scanner;

public class StringBuilderTest1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("输入字符串：");
        String s1 = s.next();
        String res1 = new StringBuilder().append(s1).reverse().toString();
        if(res1.equals(s1))
            System.out.println("是一个对称字符串");
        else
            System.out.println("不是一个对称字符串");
    }
}
//用到StringBuilder的情况：字符串的拼接和反转这两种情况
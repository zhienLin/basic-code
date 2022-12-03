package Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class Test14 {
    public static void main(String[] args) {
        //需求：给定两个整数，被除数和除数，将两个数相除，要求不使用*、/、%

        //获取两个数
        Scanner s = new Scanner(System.in);
        System.out.print("请输入被除数:");
        int dividend = s.nextInt();
        System.out.print("请输入除数:");
        int divisor = s.nextInt();

        //被除数减去除数的大小做判断
        int a = 0;//定义商变量
        while(dividend - divisor >= 0){
            a = a+1;
            dividend = dividend - divisor;
        }
        System.out.println("所得结果的商是："+ a);
        System.out.println("所得结果的余数是："+ dividend);


    }
}

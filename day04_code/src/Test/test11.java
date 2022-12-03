package Test;

import java.util.Scanner;

public class test11 {
    public static void main(String[] args) {

        //先从键盘录入两个数字
        Scanner s = new Scanner(System.in);

        System.out.print("请你输入第一个数字:");
        int num1 = s.nextInt();

        System.out.print("请你输入第二个数字:");
        int num2 = s.nextInt();

        //统计同时被3和5整除的数字
        int count = 0;//统计数字
        for ( int i = num1 ; i<= num2 ; i++  ){
             if( (i % 3) == 0 && (i % 5) == 0)
                 count = count +1;
        }
        System.out.println("在"+num1+"到"+num2+"之间的整数中，同时可以被3和5整除的数字一共有"+count);


    }
}

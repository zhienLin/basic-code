package Test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = sr.nextInt();


        /*int i;
        for (i = 2; i <= num -1 ; i++) {
            if(num % i == 0)
                break;
        }
        if(i == num)
            System.out.println("这个数字是一个质数");
        else
            System.out.println("这个数字是一个合数");*/

        //way1
        //定义一个变量，表示标记，标记着num是一个质数，true代表是一个正数，而false表示是一个合数，就像是引入了一个中间变量。
        boolean flag = true;
        for (int i = 2; i <= num -1 ; i++) {
            if(num % i == 0)
                flag =  false;
                break;
        }

        if(flag)
            System.out.println("这个数字是一个质数");
        else
            System.out.println("这个数字是一个合数");




    }
}

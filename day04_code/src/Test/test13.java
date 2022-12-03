package Test;

import java.util.Scanner;

public class test13 {
    public static void main(String[] args){
        /*//从键盘输入一个整数（-2147483648~2147483647）
        Scanner s = new Scanner(System.in);
        System.out.println("回文数判断");
        System.out.print("请输入一个待判断的整数:");
        int num = s.nextInt();

        //获取该整数的位数以及各位对应的数值(while)
        //记录位数
        int i = 0;
        //把对应的位的数字放在数组中
       int arr[]=new int[11];
        while (num > 0){
            i = i+1;
            arr[i] = num % 10;
            num = num/10;
        }

        //偶数情形：成对判断；奇数情形：中间值不判断
        int com = 0;
        for ( int a = 1; a <= i/2; a++) {
                if (arr[a] != arr[i-a + 1])
                com = 1;
        }

        if(com == 0)
            System.out.println("是回文数.");
        else
            System.out.println("不是回文数.");*/

        //从键盘输入一个整数（-2147483648~2147483647）
        Scanner s = new Scanner(System.in);
        System.out.println("回文数判断");
        System.out.print("请输入一个待判断的整数:");
        int num = s.nextInt();

        int i = 0;
        int ver = 0;
        int temp = num;
        while (temp > 0){
            i = i+1;
            ver = ver * 10 + temp % 10;
            temp = temp/10;
        }

        if(num == ver)
            System.out.println("是回文数.");
        else
            System.out.println("不是回文数.");

    }
}

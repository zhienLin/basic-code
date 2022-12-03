package homwork;

import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.print("请您输入一个五位整数：");
        int num = sr.nextInt();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum =  sum + num % 10;
            num = num / 10;
        }

        System.out.println("这个五位数各位相加的结果是："+ sum);

    }
}

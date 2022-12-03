package homwork;

import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.print("请输入一个两位的整数:");
        int num = sr.nextInt();
        int quotient, remainder, sum;
        quotient = num / 10;
        remainder = num % 10;
        sum = quotient + remainder;

        if(quotient == 6 || remainder == 6)
            System.out.println("true");
        else if(sum % 6 == 0)
            System.out.println("true");
        else
            System.out.println("false");

    }
}

package www.itheima.demo;

import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入您需要解密的数字:");
        int num = s.nextInt();
        System.out.println(num + "解密后的结果是：" + getDecrypt(num));
    }


    public static int getDecrypt(int num) {
        int count = 1;
        int temp = num;
        int result = 0;
        while (num / 10 != 0) {
            count++;
            num /= 10;
        }

        for (int i = 1; i <= count; i++) {
            if (temp % 10 > 5)
                result = result * 10 + (temp % 10 - 5);
            else
                result = result * 10 + (temp % 10 + 5);
            temp /= 10;

        }
        return result;
    }
}

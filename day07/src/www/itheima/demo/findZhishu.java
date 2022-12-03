package www.itheima.demo;

import java.util.Random;

public class findZhishu {
    public static void main(String[] args) {
       for (int i = 101; i <= 200; i++) {
            if (judge(i))
                System.out.print(i + " ");
       }
    }

    public static boolean judge(int num1) {
        for (int i = 2; i < num1 - 1; i++) {
            if (num1 % i == 0)
                return false;
        }
        return true;
    }

}


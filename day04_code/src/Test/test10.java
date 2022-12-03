package Test;

import java.util.Scanner;

public class test10 {
    public static void main(String[] args) {
//        先进行键盘的录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入当前的星期数：");
        int week = sc.nextInt();

//        在进行选择、程序编写
        switch (week){
            case 1 : case 2: case 3: case 4: case 5:
                     System.out.println("今天为工作日");break;
            case 6: case 7:
                     System.out.println("今天为休息日");break;
            default: System.out.println("您输入的数字不合法");

        }

    }
}


package com.itheima.demo;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MethodReloadTest2 {
    public static void main(String[] args) {

        int arr [] = {90,54,87,35,46,89,342,56};
        System.out.println("这个数组元素中最大值是"+getMax(arr));

        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int b = s.nextInt();
        if (getExitence(arr, b))
            System.out.println("此数组中有"+b);
        else
            System.out.println("此数组中没有"+b);

    }

    //获取最大值
    public static int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    //数组中知否有某个数字
    public static boolean getExitence(int arr[], int b) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return true;
            }
        }
        return false;
    }

   /* return 和break 的区别：
      return 和循环没有什么关系，跟方法有关，主要用来 结束方法和返回结果这两个作用。
             如果方法执行到了return，那么整个方法就结束了，里面的循环也就随之结束了。
      break  主要用在循环或者switch当中，和方法没有什么关系。
    */



}

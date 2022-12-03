package com.itheima.demo.Arraydemo;

import java.util.Random;

public class ArrayAverage {
    public static void main(String[] args) {
        double [] arr = new double[10];
        Random r = new Random();
        double sum = 0;
        double average = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100)+1;
            sum = sum + arr[i];
        }

        average = sum / arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < average)
                count++;
        }
        System.out.println("此数组所有数据的和是："+ sum);
        System.out.println("此数组所有数据的平均数是："+ average);
        System.out.println("此数组所有数据中小于平均数个数有："+ count+"个");

    }
}

package com.itheima.demo.Arraydemo;

import java.util.Random;

public class ArrayExchange {
    public static void main(String[] args) {

        //将数组的0索引和最大索引进行交换
/*
        int arr1 [] = {1,2,3,4,5};
        int temp1 = arr1[0];
        arr1[0] = arr1[arr1.length - 1];
        arr1[arr1.length - 1] = temp1;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+ " ");
        }
*/
        //数组元素左右两边交换, 分为两边，分别交换左右的所有变量。
        /*int arr3 [] = {1,2,3,4,5};
        int temp;
        for (int i = 0, j=arr3.length-1; i < j; i++,j--) {
            temp = arr3[i];
            arr3[i] = arr3[j];
            arr3[j] = temp;
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]+ " ");
        }*/


        //冒泡原则
        /*int arr2 [] = {1,2,3,4,5};
        int temp2 = arr2[arr2.length - 1];
        for (int i = 0; i < arr2.length - 1; i++) {
            arr2[arr2.length - 1 - i] = arr2[arr2.length - 2 - i];
        }
        arr2[0] = temp2;
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+ " ");
        }*/

        //打乱数组中的所有数据的顺序
/*        int arr4 [] = {1,2,3,4,5};
        int temp2;
        for (int i = 0; i < arr4.length - 1; i++) {
            Random r = new Random();
            temp2 = arr4[i];
            int j = r.nextInt(arr4.length);
            arr4[i] = arr4[j];
            arr4[j] = temp2;
        }

        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i]+ " ");
        }*/

        int arr5 [] = new int[] {1,2,3,4,5};
        int arr6 []= arr5;
        arr6 [4] = 6;
        System.out.println(arr5[4]);


    }
}

package com.itheima.demo.Arraydemo;

public class ArrayDemo2 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 3 == 0)
                count++;

            if (arr[i] % 2 ==0 )
                arr[i] = arr[i] / 2;
            else
                arr[i] = arr[i] * 2;
            System.out.println(arr[i]);
        }
        System.out.println(count);
    }
}

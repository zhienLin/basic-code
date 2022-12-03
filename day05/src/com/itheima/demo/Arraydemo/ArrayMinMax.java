package com.itheima.demo.Arraydemo;

//所有求最值得问题，临时定义的变量一定要是数组里面的某个值
public class ArrayMinMax {
    public static void main(String[] args) {
        int arr [] = {33,45,76,52,35};
        int max = arr [0];
        int min = arr [0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println("该数组的最大值是："+ max);
        System.out.println("该数组的最小值是："+ min);
    }

}

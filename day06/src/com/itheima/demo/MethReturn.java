package com.itheima.demo;

public class MethReturn {
    public static void main(String[] args) {
        int  areaSqurt1 = area (5, 3);
        int  areaSqurt2 = area (5, 4);
        if(areaSqurt1 > areaSqurt2)
            System.out.println("长方形1的面积大");
        else
            System.out.println("长方形2的面积大");
    }

    public static int area (int length, int wdith){
        int result = length * wdith;
        return result;
    }
}

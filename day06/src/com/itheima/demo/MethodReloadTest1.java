package com.itheima.demo;

public class MethodReloadTest1 {
    public static void main(String[] args) {
        int arr [] = {24,563,4,6,34};
        traverse(arr);
    }

    public static void  traverse(int arr []){
        String a = "";
        System.out.print("["+arr[arr.length-1]+", ");
        for (int i = 1; i < arr.length-1; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.print(arr[arr.length-1]+"]");

    }
}

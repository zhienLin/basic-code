package com.itheima.demo;
/*      定义一个方法copyOfRange(int[] arr,int from, int to)
        将数组arr中从索引from(包含from)开始。
        到索引to结束(不包含to)的元素复制到新数组中，将新数组返回。*/

public class MethodReloadTest3 {
 public static void main(String[] args) {
        int arr [] = {7,6,3,1,8,4,5,2};
        int from = 1;
        int to = 7;
        int arr2 [] = copyOfRange(arr, from, to);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
 }

    public static int[]  copyOfRange(int[] arr,int from, int to){
        int arr1 [] = new int[to - from -1];
        for (int i = 0; i < to - from -1; i++) {
            arr1 [i] = arr [from + i];
        }
        return arr1;
    }

}

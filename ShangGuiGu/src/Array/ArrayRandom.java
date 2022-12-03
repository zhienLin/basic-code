package Array;

import java.util.HashSet;
import java.util.Random;

public class ArrayRandom {
/*  创建一个长度为6的int型数组，
    要求数组元素的值都在1-30之间，且是随机赋值。
    同时，要求元素的值各不相同。*/

    public static void main(String[] args) {
        int[] arr = new int[6];

        HashSet<Integer> hs = new HashSet<>();
        Random r = new Random();

        for (int i = 0; i < arr.length; ) {
            int num = r.nextInt(30) + 1;
            boolean flag = hs.add(num);
            if(flag != false) {
                arr[i] = num;
                i++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ "  ");
        }
    }
}

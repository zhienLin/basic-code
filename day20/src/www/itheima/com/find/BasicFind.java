package www.itheima.com.find;

import java.util.ArrayList;

//在给定的数组中查找某个数值，并返回对应的索引（考虑重复的情况）
public class BasicFind {
    public static void main(String[] args) {
        int arr[] = {4, 45, 5, 6, 89,4};
        int verifyNum = 1;
        ArrayList<Integer> arrayList = findNum(arr, verifyNum);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+ " ");
        }
    }

    private static ArrayList<Integer> findNum(int[] arr, int verifyNum) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == verifyNum)
                list.add(i);
        }
        return list;
    }
}

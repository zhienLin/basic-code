import java.util.Arrays;

public class Z0915 {
/*  给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
    与标准答案 误差在 10-5 的结果都被视为正确结果*/

    public static void main(String[] args) {
        int arr[] = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        System.out.println(trimMean(arr));
    }

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int preIndex = (int) arr.length / 20;
        double average = 0;
        for (int i = preIndex; i < arr.length - preIndex; i++) {
            average = average + arr[i];
        }
        return average / (arr.length - preIndex*2);


    }


}


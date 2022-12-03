package www.itheima.com.order;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        //有序的起始索引
        int startIndex = index(arr);

        //拿着后面所有无序的值跟前面的有序进行比较
        for (int i = startIndex + 1; i < arr.length; i++) {

            int j = i;

            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }

        }

        //验证
        printArr(arr);

    }

    //找到最有序的结束索引
    private static int index(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return i;
        }
        return arr.length - 1;
    }

    //打印数组各个元素
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
/*  插入排序:
    将0索引的元素到N索引的元素看做是有序的。
    把N+1索引的元素到最后一个当成是无序的。
    遍历无序的数据，将遍历到的元素插入有序序列中适当的位置。
    如遇到相同数据，插在后面。
    N的范围: 0~最大索引 */

//在进行插入排序的时候，先要找到前面有序列的一部分，然后后面没有序列的依次插入其中
//然后在在插入的时候，从后往前依次比较，符合条件的话就交换位置。
//判断条件主要有：一直到起始索引或者不在符合条件
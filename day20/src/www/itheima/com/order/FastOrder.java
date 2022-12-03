package www.itheima.com.order;

public class FastOrder {
    public static void main(String[] args) {
        int[] arr = {6, 2, 1, 7, 9, 3, 4, 5, 10, 8};
        Order(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void Order(int[] arr, int i, int length) {
        //i是基准数对应的索引，我们需要把i之后的数值分别从两边进行比较。
        //使得比左边的都大，比右边的都小。
        int start = i;
        int end = length;
        if (start > end)
            return;
        while (start != end) {

            while (true) {
                if (start == end || arr[end] < arr[i])
                    break;
                else
                    end--;
            }

            while (true) {
                if (start == end || arr[start] > arr[i])
                    break;
                else
                    start++;
            }

            //把end和start指向的元素进行交换
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
        }

        //基准元素放在指定位置
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;

        //对6左边的在进行递归的调用，进行排序
        Order(arr, i, start - 1);

        //对6右边的在进行递归的调用，进行排序
        Order(arr, start + 1, length);


    }

}


/*
1.冒泡排序:
        相邻的元素两两比较，小的放前面，大的放后面
2.选择排序:
        从0索引开始，拿着每一个索引上的元素跟后面的元素依次比较
        小的放前面，大的放后面，以此类推
3.插入排序:
        将数组分为有序和无序两组，遍历无序数据，将元素插入有序序列中即可。
4.快速排序
        ●将排序范围中的第一个数字作为基准数，再定义两个变量start, end。
        ●start从前往后找比基准数大的，end从后往前找比基准数小的。
        ●找到之后交换start和end指向的元素，并循环这一过程，直到start和end。
        处于同一个位置，该位置是基准数在数组中应存入的位置，再让基准数归
        位。
        ●归位后的效果:基准数左边的，比基准数小基准数右边的，比基准数大。
*/

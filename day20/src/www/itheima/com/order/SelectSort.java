package www.itheima.com.order;

public class SelectSort {
    /*
      选择排序:
      核心思想:
      从0索引开始，拿着每一个索引上的元素跟后面的元素一次比较，
      小的放在前面，大的放在后面，以此类推
      */
    public static void main(String[] args) {
        //1.定义数组
        int[] arr = {2, 4, 5, 3, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}

//个人感觉选择排序比冒泡排序要好理解很多
package www.itheima.com.find;

//[7 23 79 81 103 127 131 147] 找131 要用到2分查找
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {7, 23, 79, 81, 103, 129, 131, 147};
        int num = 149;
        int index = findIndex(arr, num);
        System.out.println(index);
    }

    private static int findIndex(int[] arr, int num) {
        int min = 0;
        int max = arr.length;
        int mid = (min + max) / 2;
        while (true) {
            if (max <= min)//max < 0 || min > 7
                return -1;
            else {
                if (arr[mid] == num)
                    break;
                else if (arr[mid] < num) {
                    min = mid + 1;
                    mid = (min + max) / 2;
                } else {
                    max = mid - 1;
                    mid = (min + max) / 2;
                }

            }
        }
        return mid;
    }
}

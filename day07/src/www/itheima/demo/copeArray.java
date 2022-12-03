package www.itheima.demo;

public class copeArray {
    public static void main(String[] args) {
        int[] arr = {3,23,4,5,76,8,97,43,1,3};
        int [] newarr = arr;
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(newarr[i]);
            System.out.println(arr[i]);
        }
    }

}


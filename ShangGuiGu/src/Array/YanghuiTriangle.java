package Array;

public class YanghuiTriangle {
    public static void main(String[] args) {
        //1.定义二维数组，一共是10行的杨辉三角，所以一共有10个一维数组
        //因为每一行的一维数组长度不一致，因此这里不对二维数组进行定义
        int[][] arr = new int[10][];
        //2.遍历每一个一维数组
        for (int i = 0; i < arr.length; i++) {
            //3.指定一维数组的长度
            arr[i] = new int[i+1];
            //4.确定每一个起始元素的值，取为1
            arr[i][0] = 1;
            arr[i][i] = 1;
            for (int j = 1; j < arr[i].length -1 ; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }

        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }

    }
}

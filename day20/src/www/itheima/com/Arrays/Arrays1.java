package www.itheima.com.Arrays;

import java.util.Arrays;

public class Arrays1 {
    public static void main(String[] args) {
/*
        public static String toString(数组) 把数组拼接成一个字符串
        public static int binarySearch(数组，查找的元素) 二分查找法查找元素
        public static int[] copyOf(原数组，新数组长度) 拷贝数组
        public static int[] copyOfRange(原数组，起始索引，结束索引)拷贝数组(指定范围)
        public static void fill(数组,元素)填充数组
        public static void sort(数组)按照默认方式进行数组排序
        public static void sort(数组，排序规则)按照指定的规则排序*/


//===================================================================================

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //1、数组变成字符串
        System.out.println(Arrays.toString(arr));
        //底层原理就是变成了一个StringBuilder的对象，最后在转换成字符串的形式。

        //2、二分查找法查找元素
        System.out.println(Arrays.binarySearch(arr,1));
        System.out.println(Arrays.binarySearch(arr,10));
        System.out.println(Arrays.binarySearch(arr,11));
        System.out.println(Arrays.binarySearch(arr,15));
        System.out.println(Arrays.binarySearch(arr,0));
        /*
        1、要求查找的数组必须是升序排列的
        2、如果所查找的数在数组中，那么返回的就是此数对应的索引
        3、如果所查找的数不在数组中，返回的是应该 ：- 插入点的位置 -1
        4、为什么一定有-1，因为如果出现插入点是0的情况，那么就是-0，看起来不妥，所以在设计的时候就减1
         */


        //3、拷贝数组
        int[] newArr1 = Arrays.copyOf(arr, 10);
        int[] newArr2 = Arrays.copyOf(arr, 14);
        System.out.println(Arrays.toString(newArr1));
        System.out.println(Arrays.toString(newArr2));
        /*
        参数一:老数组
        参数二:新数组的长度.
        方法的底层会根据第二个参数来创建新的数组
        如果新数组的长度是小于老数组的长度，会部分拷贝
        如果新数组的长度是等于老数组的长度，会完全拷贝
        如果新数组的长度是大于老数组的长度，会补上默认初始值.
         */


        //4、拷贝数组,并指定拷贝范围(如果超过范围还是会补上默认的初始化值)
        int[] newArr3 = Arrays.copyOfRange(arr, 0,3);
        int[] newArr4 = Arrays.copyOfRange(arr, 5,11);
        System.out.println(Arrays.toString(newArr3));
        System.out.println(Arrays.toString(newArr4));

        //5、填充数组
        Arrays.fill(arr,5,7,0);
        System.out.println(Arrays.toString(arr));

    }
}

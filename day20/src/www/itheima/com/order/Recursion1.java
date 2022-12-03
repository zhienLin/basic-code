package www.itheima.com.order;

public class Recursion1 {
    public static void main(String[] args) {
        //需求：用递归的方法求1~100之间的和
        //大问题拆成小问题

        int sum = getSum(100);

        System.out.println(sum);

    }

    public static int getSum(int num) {
        if (num == 1) {
            return 1;
        } else
            return num + getSum(num - 1);

    }

}

/*
关键点是大问题化解成为小问题
求1~100，
1、求100 + 1~99
2、求 99 + 1~98
.....
求 2 到 1~1；（这个才是出口）
 */

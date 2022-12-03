package www.itheima.com.order;

public class Recursion2 {
    public static void main(String[] args) {
        //需求：用递归的方法求5的阶乘，并把结果在控制台输出
        //大问题拆成小问题
        //再次调用方法的时候一定要比上一次更加靠近出口
        System.out.println(getFactorial(5));

    }

    public static int getFactorial(int num) {
        if (num == 1) {
            return 1;
        } else
            return num * getFactorial(num - 1);

    }

}


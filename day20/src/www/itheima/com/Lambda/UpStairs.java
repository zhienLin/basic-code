package www.itheima.com.Lambda;
/*可爱的小明特别喜欢爬楼梯,他有的时候一次爬一个台阶,有的时候一次爬两个台阶,有的时候一次爬三个台阶。
如果这个楼梯有20个台阶,小明一共有多少种爬法呢?*/

public class UpStairs {
    public static void main(String[] args) {
        int wayNum = getWayNum(20);
        System.out.println(wayNum);
    }

    private static int getWayNum(int stepNum) {
        if (stepNum == 1)
            return 1;
        else if (stepNum == 2)
            return 2;
        else if (stepNum == 3)
            return 4;
        else
            return getWayNum(stepNum - 1) + getWayNum(stepNum - 2)
                    +getWayNum(stepNum - 3);
    }
}

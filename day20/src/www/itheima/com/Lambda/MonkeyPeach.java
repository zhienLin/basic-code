package www.itheima.com.Lambda;

/*
有一堆桃子，猴子第一天吃了其中的一半，并多吃了一个!
        以后每天猴子都吃当前剩下来的一半，然后再多吃一个，
        第10天的时候(还没吃)，发现只剩下一个桃子了，请问，最初总共多少个桃子?
        day10:1
        day9:(day10+1)*2=4
        day8:(day9 + 1)*2= 10
        每一天的桃子数量都是后一天数量加1，乘以2
*/


public class MonkeyPeach {
    public static void main(String[] args) {
        int peachNum = getNum(0);
        System.out.println(peachNum);

    }

    private static int getNum(int day) {
        if (day > 10 || day <= 0)
            return -1;
        else {
            if (day == 10)
                return 1;
            else
                return (getNum(day + 1) + 1) * 2;
        }
    }


}

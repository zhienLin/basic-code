package www.itheima.demo;

public class NarcissisticNumber {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 10; i < 99; i++) {
            num = num + cheakNum(i);
        }
        System.out.println(num);

    }
    public static int cheakNum(int a) {
        int count = 0;//计算位数
        int sum = 0;//存储和
        int singleDigit = 0;
        int midvalue = a;//中间值，用来计算和的
        int cheakvalue = a;//校验值
        while (a != 0) {
            count++;
            a = a / 10;
        }
        for (int i = 1; i <= count; i++) {
            singleDigit = (int) (singleDigit + Math.pow(midvalue % 10,count));
            midvalue = midvalue / 10;
        }
        if(singleDigit == cheakvalue)
            return 1;
        else
            return 0;
    }
}


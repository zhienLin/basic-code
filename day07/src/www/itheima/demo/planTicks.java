package www.itheima.demo;

import java.util.Scanner;

public class planTicks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("尊敬的旅客您好！");
        System.out.print("请输入飞机票的原价：");
        int price = s.nextInt();
        System.out.print("请输入您想购买机票的月份：");
        int month = s.nextInt();
        System.out.print("请输入机票的类型(1为经济舱，0为头等舱)：");
        int type = s.nextInt();

        int finallPrice;

        if (month >= 5 && month <= 10) {
            finallPrice = getFinallPrice(price, type, 0.85, 0.9);

        } else {
            finallPrice = getFinallPrice(price, type, 0.65, 0.7);
        }

        System.out.println("您打算乘坐的飞机的机票价格为：" + finallPrice);


    }

    public static int getFinallPrice(int price, int type, double v, double v2) {
        int finallPrice;
        if (type == 0)
            finallPrice = (int) (price * v);
        else
            finallPrice = (int) (price * v2);
        return finallPrice;
    }

}
//自动抽取代码：Ctrl + Alt + M
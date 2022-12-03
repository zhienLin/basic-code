package Test;

import java.util.Random;
import java.util.Scanner;
       /*获取一个随机数的方法
        1、导包 2、创建对象 3、生成随机数
        这个数的范围是从0开始的
        一直到这个数-1结束
        口诀：包头不包尾，包左不包右
        */

           /*生成任意范围的随机数：7~15
       1、头尾都减去一个值，让这个范围从0开始
       2、尾巴+1
       3、最终的结果在加上第一步减去的值 （8-12） */


public class Test5 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        int radom = r.nextInt(100)+1;//1~100的随机数
        int baodi = 0;
        for (; ; ) {
            System.out.print("请输入您猜的数字:");
            int guess = s.nextInt();
            if (guess > radom) {
                System.out.println("您猜的数字大了");
                System.out.print('\n');
                baodi +=1;
            }
            else if (guess < radom){
                System.out.println("您猜的数字小了");
                System.out.print('\n');
                baodi +=1;

            }
            else {
                System.out.println("恭喜您，猜中了");
                break;
            }

            if (baodi == 3)
                System.out.println("您所猜测的数字是："+radom);

        }
    }
}

package www.itheima.demo;
/*数字加密的问题
先得到每位数，然后都加上5，在对10求余数，得到一串新数
来表示这串新数的方法就是数字加密的方法

 */

import java.util.Scanner;

public class Secret {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入您需要加密的数字:");
        int num = s.nextInt();
        System.out.println(num + "加密后的结果是：" + getSecret(num));
    }

    public static int getSecret(int num) {

        //得到位数
        int temp = num;
        int count = 1;
        while (temp / 10 != 0) {
            count++;
            temp = temp / 10;
        }
        System.out.println(count);
        //把每一位放在一个数组里面
        int result = 0;
        for (int i = 0; i < count; i++) {
            result = result * 10 + (num % 10 + 5) % 10 ;
            num = num / 10;
        }
        return result;
    }
}
//这里总是会弄错一件事情，那就是在判断位数的时候，num已经是除完之后的值了，
// 下面在用去num进行运算，肯定不是num最开始时候的值，下次一定要注意。
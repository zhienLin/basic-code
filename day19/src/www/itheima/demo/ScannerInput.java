package www.itheima.demo;

import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
/*        String str = sc.next();
        System.out.println(str);*/
//弊端:
//当我们在使用next，nextInt， nextDouble在接收数据的时候，遇到空格，回车，制表符的时候就停止了
//键盘录入的是123 123 那么此时只能接收到空格前面的数据
//我想要的是接收一整行数据
//约定:
//以后我们如果想要键盘录入，不管什么类型，统一使用nextLine
//特点遇到回车才停止
     String str = sc.nextLine();
     int i = Integer.parseInt(str);
     System.out.println(i);
    }
}

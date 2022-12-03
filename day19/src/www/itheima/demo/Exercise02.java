package www.itheima.demo;

import java.util.Scanner;

/*输入一个1-10位的正整数形式的字符串
然后转换成对应的整数形式进行输出
不用函数的形式*/

public class Exercise02 {
    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个1-10位的正整数:");
        String regexNum = "[1-9]\\d{0,9}";//定义正则表达式
        String intNum = sc.nextLine();
        boolean matches = intNum.matches(regexNum);
        if(!matches){
            System.out.println("您输入的数据格式有误");
        }else
        {
            for (int i = 0; i < intNum.length(); i++) {
                num = num * 10 + (intNum.charAt(i) - '0');
            }
            System.out.println(num);
        }



    }
}

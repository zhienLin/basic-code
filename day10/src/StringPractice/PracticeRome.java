package StringPractice;

import java.util.Scanner;

public class PracticeRome {
    public static void main(String[] args) {

        String sint = "lk";
        //制定转换的数组
        String[] arrreplaced = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ"};
        String[] arrreplace = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        //输入一个合法的字符串
        Scanner s = new Scanner(System.in);
        /*while (true) {
            int count = 0;
            System.out.print("请输入一个全由数字组成的位数小于9的字符串：");
            sint = s.next();
            if (sint.length() > 9) {
                System.out.println("您输入的字符串位数不符合规范。");
                continue;
            }
            for (int i = 0; i < sint.length(); i++) {
                if (!(sint.charAt(i) >= '0' && sint.charAt(i) <= '9')) {
                    System.out.println("您输入的字符串不符合规范。");
                    count++;
                    break;
                }
            }
            if (count == 0)
                break;
        }*/ //自己的方法，推荐使用老师的方法。因为这里卡了
        while (true) {
            System.out.print("请输入一个全由数字组成的位数小于9的字符串：");
            sint = s.next();
            if (check(sint)) {
                break;
            } else
                continue;
        }//老师的方法

        //转换罗马字符
        for (int i = 0; i < sint.length(); i++) {
            for (int j = 0; j < 10; j++) {
                sint = sint.replace(arrreplace[j], arrreplaced[j]);
            }
        }
        System.out.print("将上述的数字字符串转化为罗马字符串的形式为：" + sint);

    }

    //检查数组是否符合规范
    public static boolean check(String s) {
        if (s.length() > 9)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }
}

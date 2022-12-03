package www.itheima.demo;

import java.util.Scanner;

public class IdAbstract {
    public static void main(String[] args) {
        String idnumber;
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("请输入身份证号码：");
            idnumber = s.next();
            if(idnumber.length() != 18)
            System.out.println("对不起，您输入的身份证号码有误。");
            else break;
        }
        System.out.println("人物信息为：");
        String year = idnumber.substring(6,10);
        String month = idnumber.substring(10,12);
        String day = idnumber.substring(12,14);

        System.out.println("出生年月日："+ year+"年"+month+"月" +day+"日");
        System.out.println(idnumber.charAt(16) - '0');
        if ((idnumber.charAt(16) - '0') % 2 == 0 )
            System.out.println("性别为女");
        else
            System.out.println("性别为男");
    }



}

package www.itheima.demo;

import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        String name = "筱筱";
        String id = "007";
        int index = 3;
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("请您输入用户名：");
            String textName = s.next();
            if(textName.equals(name)){
                System.out.print("请您输入密码：");
                String textId = s.next();
                if(textId.equals(id)){
                    System.out.println("恭喜您登录成功");
                    break;
                }else
                    System.out.println("对不起，您的密码输入错误。您还有"+(2-i)+"次机会");
            } else
                System.out.println("对不起，当前用户不存在。您还有"+(2-i)+"次机会");
        }
        //ctrl + Alt +T可以对所选择的语句进行整体的操作，比如for，while.....


    }
}

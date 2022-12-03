package www.itheima.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Han1 {


    public static void main(String[] args) {
        homepagePrint();
    }

    //首页+功能操作入口
    public static void homepagePrint() {
        System.out.println("-------------欢迎来到大刚上班心情管理系统----------------");
        System.out.println("1：开心");
        System.out.println("2：难过");
        System.out.println("3：失望");
        System.out.println("4：兴奋");
        System.out.println("5：平和");
        System.out.print("请输入您今日的心情选择:");

        Scanner sc = new Scanner(System.in);//键盘的录入
        String input = sc.next();//*这里尽量不要选择录入整数，因为对不是整数的操作可能并不友好。
        switch (input) {
            case "1": {
                add();
                break;
            }
            case "2": {
                delete();
                break;
            }
/*            case "3": {
                modify(list);
                break;
            }
            case "4": {
                inquire(list);
                break;
            }
            case "5": {
                System.out.println("期待您再次登录黑马学生管理系统。");
                System.exit(0);
            }
            default: {
                System.out.println("您输入的操作键有误。,请重新输入您想操作的功能键");
                homepagePrint(list);
                break;
            }*/
        }
    }

    //添加功能
    public static void add() {
        Scanner sc = new Scanner(System.in);
        //录入id并检查唯一性
        System.out.print("今天是开心的一天呢！今天想吃什么呢？");
        String id = sc.next();
        switch(id){
            case "蛋糕":
                System.out.println("吃甜食会让心情变美呦！");
                break;
            case "锅包肉":
                System.out.println("真是妥妥的东北汉子！");
                break;
            case "减脂餐":
                System.out.println("又是朝着陈伟霆进阶的一天！");
                break;
            case "面条":
                System.out.println("碳水yyds！");
                break;
        }
        homepagePrint();
    }

    //删除功能
    public static void delete() {
        System.out.println("不，我不允许你不快乐！");
        System.out.println("快去成为一个合格的干饭人吧！");
        System.out.println("韩克刚周一午餐可以选择：");
        System.out.println("1、广西螺蛳粉");
        System.out.println("2、广东白切鸡");
        System.out.println("3、北京烤鸭");
        System.out.println("4、上海生煎包");
        System.out.println("5、四川回锅肉");
        System.out.println("6、重庆辣子鸡");
        System.out.println("7、河北驴肉火烧");
    }



}

/*Summarization:
1、在用switch进行选择的时候，本题要求由控制台输入。考虑到容错性，我们可以录入选择字符串的形式，而不是整数。这样就算我们输错了还可以在default里面包含进去。
2、        switch (input) {
            case "1" -> add(list);
            case "2" -> delete(list);
            case "3" -> modify(list);
            case "4" -> inquire(list);
            case "5" -> System.out.println("期待您再次登录黑马学生管理系统。");
            default: -> {System.out.println("您输入的操作键有误。,请重新输入您想操作的功能键");
                         homepagePrint(list);}
        }
        上面的case可以在jdk12以后这么写

3、loop : while(true)
   break loop;
   这样就可以直接退出了这个循环，不会太在意优先级。

4、System.exit(0); 是停止虚拟机运行。

5、\t可以理解为一个长度可以发生改变的空格，原理是跟前面打印相关，补齐8个字符 ，或者8的倍数。
 */

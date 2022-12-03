package www.itheima.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class StuManSys1 {
    //私有的就是不希望外界获取，static是因为下面的主方法是static，静态的只能调用静态的，final的意思就是不更改。
    //这样做的目的是增加了代码的可读性。
    private  static final String ADD     = "1";
    private  static final String DELETE  = "2";
    private  static final String MODIFY  = "3";
    private  static final String INQUIRE = "4";
    private  static final String EXIT    = "5";
    public static void startStudentSystem() {
        ArrayList<UpgradeStu> list = new ArrayList<>();//学生的集合
        homepagePrint(list);
    }

    //首页+功能操作入口
    public static void homepagePrint(ArrayList<UpgradeStu> list) {
        System.out.println("-------------欢迎来到黑马学生管理系统----------------");
        System.out.println("1：添加学生");
        System.out.println("2：删除学生");
        System.out.println("3：修改学生");
        System.out.println("4：查询学生");
        System.out.println("5：退出");
        System.out.print("请输入您的选择:");

        Scanner sc = new Scanner(System.in);//键盘的录入
        String input = sc.next();//*这里尽量不要选择录入整数，因为对不是整数的操作可能并不友好。
        switch (input) {
            case ADD: {
                add(list);
                break;
            }
            case DELETE: {
                delete(list);
                break;
            }
            case MODIFY: {
                modify(list);
                break;
            }
            case INQUIRE: {
                inquire(list);
                break;
            }
            case EXIT: {
                System.out.println("期待您再次登录黑马学生管理系统。");
                System.exit(0);
            }
            default: {
                System.out.println("您输入的操作键有误。,请重新输入您想操作的功能键");
                homepagePrint(list);
                break;
            }
        }
    }

    //添加功能
    public static void add(ArrayList<UpgradeStu> list) {
        Scanner sc = new Scanner(System.in);
        //录入id并检查唯一性
        System.out.print("请输入您想录入的学生id:");
        String id = sc.next();
        if (check(list, id) == -1) {
            //录入name
            System.out.print("请输入您想录入的学生姓名:");
            String name = sc.next();
            //录入age
            System.out.print("请输入您想录入的学生年龄:");
            int age = sc.nextInt();
            //录入address
            System.out.print("请输入您想录入的学生家庭住址:");
            String address = sc.next();
            UpgradeStu newst = new UpgradeStu(id, name, age, address);
            list.add(newst);
            System.out.println("添加学生信息成功");
        } else {
            System.out.println("对不起，您输入的id已经存在");
        }
        homepagePrint(list);
    }

    //删除功能
    public static void delete(ArrayList<UpgradeStu> list) {
        if (list.isEmpty()) {
            System.out.println("当前无任何学生信息");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入您想删除的学生id:");
            String iddelete = sc.next();
            if (check(list, iddelete) != -1) {
                list.remove(check(list, iddelete));
                System.out.println("学号为" + iddelete + "的学生信息删除成功");
            } else {
                System.out.println("对不起，您输入的id号不存在。无法删除");
            }
        }
        homepagePrint(list);
    }

    //修改功能
    public static void modify(ArrayList<UpgradeStu> list) {
        if (list.isEmpty()) {
            System.out.println("当前无任何学生信息");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入您想修改的学生id:");
            String idmodify = sc.next();
            if (check(list, idmodify) != -1) {
                System.out.print("将学号为" + idmodify + "的学生姓名修改为：");
                String rename = sc.next();
                System.out.print("将学号为" + idmodify + "的学生年龄修改为：");
                int reage = sc.nextInt();
                System.out.print("将学号为" + idmodify + "的学生家庭住址修改为：");
                String readress = sc.next();
                list.get(check(list, idmodify)).setName(rename);
                list.get(check(list, idmodify)).setAge(reage);
                list.get(check(list, idmodify)).setAddress(readress);
                System.out.println("学号为" + idmodify + "的学生信息修改成功");
            } else {
                System.out.println("对不起，您输入的id号不存在。无法修改");
            }
        }
        homepagePrint(list);
    }

    //查询功能
    public static void inquire(ArrayList<UpgradeStu> list) {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        System.out.println("id\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() +"\t" + list.get(i).getName() +"\t"+
                    list.get(i).getAge() +"\t"+ list.get(i).getAddress() );
        }
        System.out.println("id          姓名    年龄   家庭住址");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "    " + list.get(i).getName() + "    " +
                    list.get(i).getAge() + "    " + list.get(i).getAddress());
        }

        homepagePrint(list);
    }

    //id是否存在并返回对应的索引，若不存在返回-1
    public static int check(ArrayList<UpgradeStu> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId()))
                return i;
        }
        return -1;
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

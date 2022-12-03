package www.itheima.demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StuManSys2 {
    public static void main(String[] args) {
        //首先定义集合，接下来需要用到。
        ArrayList<StuLogin> listpre = new ArrayList<>();
        //操作入口
        homepagePre(listpre);

    }

    //首页+功能操作入口
    public static void homepagePre(ArrayList<StuLogin> listpre) {
        System.out.println("-------------欢迎来到学生管理系统----------------");
        System.out.print("请选择操作1登录 2注册 3忘记密码:");

        Scanner sc = new Scanner(System.in);//键盘的录入
        String input = sc.next();//*这里尽量不要选择录入整数，因为对不是整数的操作可能并不友好。
        switch (input) {
            case "1": {
                login(listpre);
                break;
            }
            case "2": {
                register(listpre);
                break;
            }
            case "3": {
                retrievePassword(listpre);
                break;
            }
            case "4": {
                System.out.println("谢谢使用，再见！");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("您输入的操作键有误。请重新输入您想操作的功能键");
                homepagePre(listpre);
                break;
            }
        }
    }

    //1、注册
    public static void register(ArrayList<StuLogin> listpre) {
        Scanner sc = new Scanner(System.in);
        String name;
        String password;
        String idnumber;
        String phonenumber;

        //录入用户名并检查唯一性
        while (true) {
            System.out.print("请输入您想注册的用户名:");
            name = sc.next();
            if (checkname(listpre, name))
                break;
        }
        //录入密码并验证
        while (true) {
            System.out.print("请输入密码:");
            password = sc.next();
            System.out.print("请在此确认密码:");
            String repassword = sc.next();
            if (password.equals(repassword)) {
                break;
            }else{
                System.out.println("您两次输入的密码不一致，请您重新输入");
            }
        }
        //录入身份证号并确认
        while (true) {
            System.out.print("请输入身份证号:");
            idnumber = sc.next();
            if (checkidnumber(idnumber))
                break;

        }
        //录入手机号并确认
        while (true) {
            System.out.print("请输入手机号:");
            phonenumber = sc.next();
            if (checkphonenumber(phonenumber))
                break;
        }
        StuLogin newst = new StuLogin(name, password, idnumber, phonenumber);
        listpre.add(newst);
        System.out.println("注册成功");
        homepagePre(listpre);
    }

    //2、登录
    public static void login(ArrayList<StuLogin> listpre) {
        int temp = 0;//用来判断用户名是否存在，如果存在则为1，不存在为0
        int times = 0;//用来判断密码的校验次数
        int index = 0;//记录特定用户名所处的位置
        int countpassword = 0; //记录密码在3次之内是否验证成功
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.next();
        //用户名如果存在，temp的值为1，index的值为对应的索引。
        for (int i = 0; i < listpre.size(); i++) {
            if(listpre.get(i).getName().equals(name)) {
                temp++;
                index= i;
            }

        }
        if(temp == 0) {
            System.out.println("用户名未注册，请先注册");
            return;
        }
        String verCode = verifyCode();
        System.out.println("验证码为：" + verCode);
        System.out.println("请输入验证码");
        String verifynum = sc.next();
        while(true) {
            if (!(verifynum.equalsIgnoreCase(verCode))) {
                System.out.println("验证码输入错误，重新输入");
                verCode = verifyCode();
                System.out.println("验证码为：" + verCode);
                System.out.println("请输入验证码");
                verifynum = sc.next();
            }
            else
                break;
        }
        System.out.println("请输入用户密码");
        String password = sc.next();
/*        StuLogin useInfo = new StuLogin(name, password, null,  null);
        checkUserInfo(listpre,useInfo) ;*/
        for (int i = 0; i < 2; i++) {
            if(listpre.get(index).getPassword().equals(password)) {
                System.out.println("恭喜您登录成功");
                countpassword = 1 ;
                break;
            }
            else
                System.out.println("抱歉，您的密码输入有误，您还有"+ (2 - i) + "此机会");
                System.out.println("请重新输入用户密码");
                password = sc.next();
                countpassword = -1 ;
        }
        if( countpassword == -1){
            System.out.println("抱歉登录失败");
            homepagePre(listpre);
        }
        else{
            //创建对象调用方法，启动学生管理系统
            StuManSys1 ss = new StuManSys1();//这个是前面的一个类，相当于定义常见了一个新的这个类名的对象。
            ss.startStudentSystem();//接着调用这个对象当中可以用到的方法。
        }

    }

/*    //检查用户名和密码，是老师的方法。主要是利用了封装的思想。
    private static boolean checkUserInfo(ArrayList<StuLogin> listpre,StuLogin useInfo) {
        for (int i = 0; i < listpre.size(); i++) {
            StuLogin checkUse  = listpre.get(i);
            if (checkUse.getName( ).equals(useInfo.getName()) && checkUse.getPassword( ).equals(useInfo.getPassword()))
            return true;
        }
        return false;
    }*/

    //3、找回密码
    public static void retrievePassword(ArrayList<StuLogin> listpre){
        int index = -1;//记录用户名索引
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入您想修改密码的用户名:");
        String name = sc.next();
        if (soleCheck(listpre, name) == -1) {
            System.out.println("抱歉，您输入的用户名未注册");
            return;
        }

        index = soleCheck(listpre, name);
        System.out.print("请输入身份证号:");
        String idnumber = sc.next();
        System.out.print("请输入手机号:");
        String phonenumber = sc.next();
        if(!(listpre.get(index).getIdnumber().equals(idnumber) &&
                listpre.get(index).getPhonenumber().equals(phonenumber))){
            System.out.println("账号信息不匹配，修改失败。");
        }
        else {
            System.out.print("请输入您想修改的密码:");
            String repassword = sc.next();
            listpre.get(index).setPassword(repassword);
        }
        homepagePre(listpre);
    }

    //1.1检查姓名是否合规
    public static boolean checkname(ArrayList<StuLogin> listpre, String name) {
        int countnum = 0;//记录用户名中数字的个数
        int countword = 0;//记录用户名中字母的个数
        int countillegal = 0;//记录用户名中字母的个数
        //1、判断长度
        if (name.length() > 15 || name.length() < 3) {
            System.out.println("抱歉您输入的用户名长度不合法，请重新输入3-15位的用户名");
            return false;
        }
        //2、判断name组成是否规范
        char[] chs = name.toCharArray();
        //分别统计数字、字母和其他字符的数量
        for (int i = 0; i < chs.length; i++) {
            if ((chs[i] - '0' >= 0 && chs[i] - '9' <= 0))
                countnum++;
            else if ((chs[i] - 'a' >= 0 && chs[i] - 'z' <= 0) || (chs[i] - 'A' >= 0 && chs[i] - 'Z' <= 0))
                countword++;
            else
                countillegal++;
        }

        if (countillegal != 0) {
            System.out.println("您输入的用户名不合法，用户名只能由数字和字母组成。请重新输入");
            return false;
        }

        if (countword == 0) {
            System.out.println("您输入的用户名不合法，用户名不能只由数字组成。请重新输入");
            return false;
        }
        //3、判断唯一性
        if(soleCheck(listpre,name) != -1) {
            System.out.println("抱歉您输入的用户名已存在，请重新输入");
            return false;
        }

        return true;
    }

    //1.2检查身份证号是否合规
    public static boolean checkidnumber(String idnumber) {
        //检查长度
        if (idnumber.length() != 18) {
            System.out.println("您输入的身份证长度有误，共18位。请重新输入。");
            return false;
        }
        //检查首位
        if (!(idnumber.charAt(0) - '1' >= 0 && idnumber.charAt(0) - '9' <= 0)) {
            System.out.println("您输入的身份证首位有误。请重新输入。");
            return false;
        }
        //检查2-17位
        for (int i = 1; i < idnumber.length() - 1; i++) {
            if (!(idnumber.charAt(i) - '0' >= 0 && idnumber.charAt(i) - '9' <= 0))
                return false;
        }
        //检查末位
        if (!((idnumber.charAt(idnumber.length() - 1) - '0' >= 0 && idnumber.charAt(idnumber.length() - 1) - '9' <= 0)
                || idnumber.charAt(idnumber.length() - 1) - 'X' == 0 || idnumber.charAt(idnumber.length() - 1) - 'x' == 0))
            return false;

        return true;
    }

    //1.3检查手机号是否合规
    public static boolean checkphonenumber(String phonenumber) {
        //检查长度
        if (phonenumber.length() != 11)
            return false;
        //检查首位
        if (!(phonenumber.charAt(0) - '1' >= 0 && phonenumber.charAt(0) - '9' <= 0))
            return false;
        //检查其余各位
        for (int i = 1; i < phonenumber.length(); i++) {
            if (!(phonenumber.charAt(i) - '0' >= 0 && phonenumber.charAt(i) - '9' <= 0))
                return false;
        }
        return true;
    }

    //1.1.1检查用户名的唯一性
    public static int soleCheck(ArrayList<StuLogin> listpre, String name) {
        for (int i = 0; i < listpre.size(); i++) {
            if (name.equals(listpre.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    //2.1验证码的生成
    public static String verifyCode() {
        Random r = new Random();
        //定义验证码取值的数组
        char[] word = new char[52];
        char[] num = new char[10];
        char[] verificationCode = new char[5];
        //大写
        for (int i = 0; i < 26; i++) {
            word[i] = (char) ('A' + i);
        }
        //小写
        for (int i = 26; i < word.length; i++) {
            word[i] = (char) ('a' + i - 26);
        }
        //数字
        for (int i = 0; i < num.length; i++) {
            num[i] = (char) ('0' + i);
        }

        //先假定前4个是大小写的
        for (int i = 0; i < 4; i++) {
            verificationCode[i] = word[r.nextInt(52)];
        }
        //最后一个是数字
        verificationCode[4] = num[r.nextInt(10)];

        //打乱混顺序
        for (int i = 0; i < 5; i++) {
            int a = r.nextInt(5);
            char temp;
            temp = verificationCode[i];
            verificationCode[i] = verificationCode[a];
            verificationCode[a] = temp;
        }

        String s = new String(verificationCode);
        return s;
    }

}


/*Summarization:
1、创建方法的时候，可以先写出您想指定的方法名，例如login(),因为没有出现过，一般它会显示红色，
点击选择自动生成就好了。这样比较方便。
2、集合应该放在方法之外，这样各个方法相互调用的时候才可以进行信息的传递。
3、先验证格式是否正确，再验证是否唯一
因为在以后所有的数据，都是存在数据库中，如果我们要校验，需要使用到网络资源，这样可以避免资源的浪费。
用户名长度必须在3~15位之间，只能是字母加数字的组合，但是不能是纯数字，用户名唯一
4、注册的时候遇到了定义在循环里面，没有在定义外面用变量。所以定义写在外面，赋值写在里面。
5、equalsIgnoreCase 可以用来忽略大小写。
6、封装思想的应用:
我们可以把一些零散的数据，封装成一个对象Ⅰ
以后传递参数的时候，只要传递一个整体就可以了，不需要管这些零散的数据。
7、主要是用于调用之前已经写好的一个方法，可以把之前的类中的main方法修改成一个一般的。
然后通过创建新的对象，调用这个修改完之后的方法去实现。
 */
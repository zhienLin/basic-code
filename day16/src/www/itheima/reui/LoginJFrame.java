package www.itheima.reui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LoginJFrame extends JFrame implements MouseListener {

    //1鼠标监听
    JButton login = new JButton();
    JButton register = new JButton();
    //2验证码
    String getcode = getVerifyCode1();//获取验证码
    JLabel jLabelText = new JLabel(getcode);//添加到组件中
    //3文字框
    JTextField jLabeltalkusername = new JTextField();
    JPasswordField jLabeltalkpassword = new JPasswordField();
    JTextField jLabeltalkverifycode = new JTextField();


    //4初始化用户登录信息(没有主方法体当中，必须用static修饰)
    static ArrayList<User> userlist = new ArrayList<>();
    static {
        userlist.add(new User("张三", "001"));
        userlist.add(new User("李四", "002"));
    }


    public LoginJFrame() {
        //1初始化界面
        initialLoginJFrame();
        //2初始化图像
        initialImage();
    }

    //1初始化界面方法
    public void initialLoginJFrame() {
        this.setTitle("拼图游戏登录界面");
        this.setSize(488, 430);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    //2初始化图像方法
    public void initialImage() {
        //清除之前的图像界面
        this.getContentPane().removeAll();
        //1.1用户名
        ImageIcon iconusername = new ImageIcon("day16\\image\\login\\用户名.png");
        JLabel jLabelsername = new JLabel(iconusername);
        jLabelsername.setBounds(130, 135, 47, 17);
        this.getContentPane().add(jLabelsername);
        //1.2用户名文字框
        //4用户名输入
        JLabel username = new JLabel();
        username.setBounds(265, 100, 100, 100);
        this.getContentPane().add(username);
        //1.3用户名对话框
        jLabeltalkusername.setBounds(195, 134, 200, 30);
        this.getContentPane().add(jLabeltalkusername);
        //2.1密码
        ImageIcon iconpassword = new ImageIcon("day16\\image\\login\\密码.png");
        JLabel jLabelpassword = new JLabel(iconpassword);
        jLabelpassword.setBounds(130, 195, 32, 16);
        this.getContentPane().add(jLabelpassword);
        //2.2密码文字框
        JLabel password = new JLabel();
        password.setBounds(265, 160, 100, 100);
        this.getContentPane().add(password);
        //2.3密码对话框
        jLabeltalkpassword.setBounds(195, 195, 200, 30);
        this.getContentPane().add(jLabeltalkpassword);
        //2.4密码显示
        ImageIcon iconpassview = new ImageIcon("day16\\image\\login\\显示密码.png");
        JLabel jLabelpassview = new JLabel(iconpassview);
        jLabelpassview.setBounds(300, 195, 18, 29);
        this.getContentPane().add(jLabelpassview);

        //3.1验证码
        ImageIcon iconverifycode = new ImageIcon("day16\\image\\login\\验证码.png");
        JLabel jLabelverifycode = new JLabel(iconverifycode);
        jLabelverifycode.setBounds(130, 256, 50, 30);
        this.getContentPane().add(jLabelverifycode);
        //3.2验证码文字框
        JLabel verifycode = new JLabel();
        verifycode.setBounds(235, 220, 100, 100);
        this.getContentPane().add(verifycode);
        //3.3验证码对话框
        jLabeltalkverifycode.setBounds(195, 256, 100, 30);
        this.getContentPane().add(jLabeltalkverifycode);
        //3.4验证码显示
        jLabelText.setText(getcode);
        jLabelText.setBounds(300, 242, 60, 60);
        this.getContentPane().add(jLabelText);
        jLabelText.addMouseListener(this);

        //4.1添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("day16\\image\\login\\登录按钮.png"));
        //4.2去除按钮的默认边框
        login.setBorderPainted(false);
        //4.3去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
        //登录按钮监听器
        login.addMouseListener(this);

        //5.1添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("day16\\image\\login\\注册按钮.png"));
        //5.2去除按钮的默认边框
        register.setBorderPainted(false);
        //5.3去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);
        //注册按钮监听器
        register.addMouseListener(this);


        //6添加背景图片
        ImageIcon iconbackground = new ImageIcon("day16\\image\\login\\background.png");
        JLabel jLabelbackground = new JLabel(iconbackground);
        jLabelbackground.setBounds(0, 0, 470, 390);
        this.getContentPane().add(jLabelbackground);

        //界面显示
        this.getContentPane().repaint();

    }

    //3弹框显示
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //设置大小
        jDialog.setSize(200, 150);
        //不关闭无法进行下面的操作
        jDialog.setModal(true);
        //永远在上面
        jDialog.setAlwaysOnTop(true);
        //居中
        jDialog.setLocationRelativeTo(null);

        //创建容器把文字添加进去
        JLabel jLabelcontent = new JLabel(content);
        jLabelcontent.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(jLabelcontent);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    //4取验证码的方法
    public String getVerifyCode1() {
        //把所有随机数定义在一个数组里面
        String result = "";
        char[] random1 = new char[62];
        for (int i = 0; i < random1.length; i++) {
            if (i < 26)
                random1[i] = (char) (65 + i);
            else if (i < 52)
                random1[i] = (char) (97 + i - 26);
            else
                random1[i] = (char) (48 + i - 52);
        }

        //创建随机对象
        Random r = new Random();
        for (int i = 1; i < 5; i++) {
            result = result + random1[r.nextInt(52)];
        }
        result = result + random1[r.nextInt(10) + 52];
        return result;
    }

    //5校验用户登录
    public boolean checkLogin(ArrayList<User> userlist, String username, String password) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getName().equals(username) && userlist.get(i).getPassword().equals(password))
            return true;
        }
        return false;
    }

    //6接口的方法重载

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Scanner s = new Scanner(System.in);
        Object source = e.getSource();
        //验证码是否更换的检查
        if (source == jLabelText) {
            getcode = getVerifyCode1();
            jLabelText.setText(getcode);
            System.out.println(getcode);
        }  else if (source == login) {
            if(!jLabeltalkverifycode.getText().equals(getcode)){
                showJDialog("验证码失败");
            }else if(!checkLogin(userlist,jLabeltalkusername.getText(),jLabeltalkpassword.getText())){
                showJDialog("身份信息不符合");
            } else{
                this.setVisible(false);
                new GameJFrame();
            }
        } else if (source == register) {
            this.setVisible(false);
            new RegisterJFrame();
        };
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

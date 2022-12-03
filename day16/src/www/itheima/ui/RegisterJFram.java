package www.itheima.ui;

import javax.swing.*;

public class RegisterJFram extends JFrame{

    public RegisterJFram(){
        //设置宽和高
        this.setSize(488,500);
        //设置标题
        this.setTitle("拼图注册界面");
        //永远在上面
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//3，为什么是3呢，界面总是之后一个存在，所以一个退出就全部退出就好了。
        //设置运行可见
        this.setVisible(true);
        this.setVisible(true);
    }
}

package www.itheima.test;

import javax.swing.*;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test1 extends JFrame implements KeyListener {
    public Test1(){
    //设置宽和高
        this.setSize(400,400);
    //设置标题
        this.setTitle("事件监听测试");
    //永远在上面
        this.setAlwaysOnTop(true);
    //设置页面居中
        this.setLocationRelativeTo(null);
    //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //给整个窗体添加键盘监听
        //调用者this:本类对象，当前的界面对象，表示我要给整个界面添加监听
        //addKeyListener:表示要给本界面添加键盘监听
        //参数this:当事件被触发之后，会执行本类中的对应代码

        this.addKeyListener(this);




    //取消默认的居中放置，只有取消了，才能根据指定xy的值放置图片
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("不常用监听");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按压监听");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("释放监听");
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);

    }
}

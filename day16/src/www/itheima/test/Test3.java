package www.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 extends JFrame{
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        //设置宽和高
        jf.setSize(400,400);
        //设置标题
        jf.setTitle("事件监听测试");
        //永远在上面
        jf.setAlwaysOnTop(true);
        //设置页面居中
        jf.setLocationRelativeTo(null);
        //设置关闭模式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了，才能根据指定xy的值放置图片
        jf.setLayout(null);

        JButton jb1 = new JButton("点我啊");
        jb1.setBounds(0,0,100,50);
        JButton jb2 = new JButton("点我啊");
        jb2.setBounds(0,0,100,50);
        //jb是组件对象，你要给那个对象添加
        //add就是要添加什么监听 动作监听包含鼠标左键单击和空格。
        //1=========================================================================================
        jb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("被点击了");
            }
        });//查看源码 这里面需要ActionListener这个接口的对象，那就用匿名类创建一个就好了
        //2=========================================================================================
        //或者可以把这个接口直接放到类上面，去实现这个接口,但是不能直接在这个主函数中进行操作，因为下面方法重写不允许是static
/*        jb1.addActionListener(this);
        jb2.addActionListener(this);*/

        //接着把这个按钮添加到界面当中
        jf.getContentPane().add(jb1);



        jf.setVisible(true);
    }


/*    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(e == jb1){}
        else{}

    }*/
}

//所以这样就有两种方法
package www.itheima.ui;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener ,ActionListener{
    int[] newarr = randomArr();//图片打乱顺序
    int[] winarr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};//判断胜利的条件
    int x;//记录第0张图片所在的位置
    String path = "day16\\image\\animal\\animal3\\";//路径，用于有优化。
    int step = 0;//记录所走的步数

    //创建项目下面的条目对象 放在成员变量上，这样下面的重载方法也能够使用
    JMenuItem replayItem = new JCheckBoxMenuItem("重新游戏");
    JMenuItem reloginItem = new JCheckBoxMenuItem("重新登录");
    JMenuItem exitItem = new JCheckBoxMenuItem("关闭游戏");

    JMenuItem accountItem = new JCheckBoxMenuItem("公众号");


    //我们可以利用构造方法进行对象的默认初始化
    //这也是构造方法的作用，在这里就体现出来了
    public GameJFrame() {
        //界面初始化
        initialJFrame();
        //菜单初始化
        initialMenu();
        //图像初始化
        initialImage();

        //设置运行可见
        this.setVisible(true);
    }


    //界面初始化方法
    public void initialJFrame() {
        //设置宽和高
        this.setSize(603, 680);
        //设置标题
        this.setTitle("拼图界面");
        //永远在上面
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//3，为什么是3呢，界面总是之后一个存在，所以一个退出就全部退出就好了。

        //在初始化界面当中添加键盘监听事件
        this.addKeyListener(this);

        //取消默认的居中放置，只有取消了，才能根据指定xy的值放置图片
        this.setLayout(null);

    }
    //菜单初始化方法
    public void initialMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        //菜单上面的两个选项
        JMenu functionJmenu = new JMenu("功能");
        JMenu aboutusJmenu = new JMenu("关于我们");

        //给各个条目选项添加事件监听
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        exitItem.addActionListener(this);
        accountItem.addActionListener(this);

        //把每个条目对象添加到选项当中
        functionJmenu.add(replayItem);
        functionJmenu.add(reloginItem);
        functionJmenu.add(exitItem);

        aboutusJmenu.add(accountItem);

        //把选项添加到初始菜单中
        jMenuBar.add(functionJmenu);
        jMenuBar.add(aboutusJmenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }
    //图像初始化方法
    public void initialImage() {
        int num = 0;//图片加1
        //对之前的图片进行全部清除
        this.getContentPane().removeAll();
        //路径分为相对路径和绝对路径
        //绝对路径:一定是从盘符开始的。C: \D:
        //相对路径:不是从盘符开始的
        //调用图片的时候：相对路径相对当前项目而言的。aaa\ \bbb
        //在当前项目下，去找aaa文件夹，里面再找bbb文件夹。


        //先加载的图片在上面，后加载的图片在下面
        //判断是否成功
        if (Arrays.equals(newarr, winarr)) {
            //胜利图片的位置
            ImageIcon iconwin = new ImageIcon("day16\\image\\win.png");
            //定义一个容器来盛这个图片
            JLabel jLabelwin = new JLabel(iconwin);
            //设置组件的位置和大小
            jLabelwin.setBounds(203, 283, 197, 73);
            //如果达到这样的效果，再把这个容器添加到界面中去
            this.getContentPane().add(jLabelwin);
        }
//===========================================================================================================
        //创建一个小图片ImageIcon对象
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个JLabel对象(容器)，这个容器主要用来存放照片和文字。
                ImageIcon icon01 = new ImageIcon(path + newarr[num] + ".jpg");
                JLabel jl = new JLabel(icon01);
                jl.setBounds(83 + 105 * j, 134 + 105 * i, 105, 105);
                //把容器添加到界面当中
                //必须通过下面这个获取出来。没有必要在设置了，因为已经在创建JFrame的时候添加了。
                //就是先获取里面隐藏的容器，然后在调用add方法。

                //然后在添加边框
                //0:表示让图片凸起来
                //1:表示让图片凹下去
                jl.setBorder(new BevelBorder(BevelBorder.RAISED));

                this.getContentPane().add(jl);
                num++;
            }
        }//因为没有第16张图片，但是默认也会创建一个ImageIcon的对象，只不过这里可能会生成一个空白。

//===========================================================================================================
        //背景图片的位置
        ImageIcon icon = new ImageIcon("day16\\image\\background.png");
        //定义一个容器来盛这个图片
        JLabel jLabel = new JLabel(icon);
        //设置组件的位置和大小
        jLabel.setBounds(40, 40, 508, 560);
        //再把这个容器添加到界面中去
        this.getContentPane().add(jLabel);

//===========================================================================================================
        //步数的记录
        JLabel jLabelstep = new JLabel("步数:"+step);
        //设置组件的位置和大小
        jLabelstep.setBounds(10, 10, 75, 75);
        //再把这个容器添加到界面中去
        this.getContentPane().add(jLabelstep);


        //再一次刷新图片
        //this.getContentPane().repaint();
    }

    public int[] randomArr() {
        Random r = new Random();
        int[] arr = new int[16];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int temp;
        for (int i = 0; i < 16; i++) {
            int index = r.nextInt(16);
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            if (arr[i] == 0) {
                System.out.println(i);
                x = i;
            }
        }
        return arr;
    }


    //接口重写，主要用于监听。
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //快捷键A，查看完整的图片
        if (code == 65) {
            //清除界面
            this.getContentPane().removeAll();
            ImageIcon icon1 = new ImageIcon(path + "all.jpg");
            JLabel jLabel1 = new JLabel(icon1);
            jLabel1.setBounds(83, 134, 420, 420);
            ImageIcon icon2 = new ImageIcon("day16\\image\\background.png");
            JLabel jLabel2 = new JLabel(icon2);
            jLabel2.setBounds(40, 40, 508, 560);
            this.getContentPane().add(jLabel1);
            this.getContentPane().add(jLabel2);
            //刷新界面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!Arrays.equals(newarr, winarr)) {
            int source = e.getKeyCode();
            //左移
            if (source == 37) {
                if (x % 4 != 3) {
                    newarr[x] = newarr[x + 1];
                    newarr[x + 1] = 0;
                    x = x + 1;
                    ++step;
                    initialImage();

                }

            }
            //上移
            if (source == 38) {
                //x是当前空白图片的位置，那么x+4就是它的下面的图片的位置。我们要交换这两个图片的位置。也就是改变数组元素的值。
                if (x <= 11) {
                    newarr[x] = newarr[x + 4];
                    newarr[x + 4] = 0;
                    x = x + 4;
                    ++step;
                    initialImage();

                }

            }
            //右移
            if (source == 39) {
                if (x % 4 != 0) {
                    newarr[x] = newarr[x - 1];
                    newarr[x - 1] = 0;
                    x = x - 1;
                    ++step;
                    initialImage();

                }
            }
            //下移
            if (source == 40) {
                if (x >= 4) {
                    newarr[x] = newarr[x - 4];
                    newarr[x - 4] = 0;
                    x = x - 4;
                    ++step;
                    initialImage();

                }
            }

            if (source == 65) {
                initialImage();
            }//提示原图

            if (source == 87) {
                for (int i = 0; i < 15; i++) {
                    newarr[i] = i + 1;
                }
                newarr[15] = 0;
                x = 15;
                initialImage();
            }//一键通关

        }
    }

    //针对功能键的事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == replayItem){
            //再次打乱数组
            newarr = randomArr();
            //重新加载步数
            step = 0;
            //加载图片
            initialImage();
        }
        if(source == reloginItem){
            //关闭当前的游戏界面
            this.setVisible(false);
            //打开新的登录界面
            new LoginJFrame();

        }
        if(source == exitItem){
            System.exit(0);
        }
        if(source == accountItem){
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //给弹框设置大小
            jDialog.setSize(344,344);
            //创建图片，并且添加到JLable中
            JLabel jLabelabus = new JLabel(new ImageIcon("day16\\image\\about.png"));
            jLabelabus.setBounds(0,0,258,258);
            //把图片放置到弹框当中
            jDialog.getContentPane().add(jLabelabus);
            //弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //不关闭弹窗其他无法显示
            jDialog.setModal(true);
            //显示弹框
            jDialog.setVisible(true);

        }

    }
}

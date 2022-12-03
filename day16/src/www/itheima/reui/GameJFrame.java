package www.itheima.reui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    Random r = new Random();


    //胜利数组
    int[] winarr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    int[] winarr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    //随机数组
    int[] arr = randomArr(winarr);
    //记录空白图片的位置
    int x;
    //记录步数
    int step = 0;

    //因为下面要添加监听，所以应该放在成员变量的位置
    JMenuItem jMenuItem1 = new JMenuItem("美女");
    JMenuItem jMenuItem2 = new JMenuItem("动物");
    JMenuItem jMenuItem3 = new JMenuItem("运动");
    JMenuItem jMenuItem5 = new JMenuItem("重新登录");
    JMenuItem jMenuItem6 = new JMenuItem("关闭游戏");
    JMenuItem jMenuItem7 = new JMenuItem("公众号");
    String path = "day16\\image\\girl\\girl" + 1 + "\\";//路径的默认初始值


    public GameJFrame() {
        initialJFrame();
        initialImage();
        initialJMenu();
        //可见放在最后
        this.setVisible(true);
    }

    public void initialJFrame() {
        //1、标题
        this.setTitle("拼图游戏单机版1.0");
        //2、大小
        this.setSize(603, 680);
        //3、居中
        this.setLocationRelativeTo(null);
        //4、在界面之上
        this.setAlwaysOnTop(true);
        //5、关闭方式 0:do nonthing 1: hided window   2:the last 3:present
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //6、添加键盘监听
        this.addKeyListener(this);
        //7、取消默认的居中放置，只有取消了，才能根据指定xy的值放置图片
        this.setLayout(null);
    }

    public void initialImage() {
        //清除之前的界面之前的
        this.getContentPane().removeAll();
        JLabel jLabelText = new JLabel("步数:"+step);
        jLabelText.setBounds(40,0,100,100);
        this.getContentPane().add(jLabelText);
        //后加载的在后面
        ImageIcon imageIconWin = new ImageIcon("day16\\image\\win.png");
        JLabel jLabelWin = new JLabel(imageIconWin);
        jLabelWin.setBounds(203, 283, 197, 73);

        //判断胜利的条件
        if (Arrays.equals(arr, winarr1)) {
            this.getContentPane().add(jLabelWin);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建小图片
                ImageIcon imageIcon = new ImageIcon(path + arr[j * 4 + i] + ".jpg");
                //常见JLable,添加图片
                JLabel jLabel = new JLabel(imageIcon);
                //设置大小和位置
                jLabel.setBounds(83 + i * 105, 134 + j * 105, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //刷新
                this.getContentPane().repaint();
                //把组件添加到界面中
                this.getContentPane().add(jLabel);
            }

        }

        //创建背景图片
        ImageIcon imageIconBackGround = new ImageIcon("day16\\image\\background.png");
        //常见JLable,添加图片
        JLabel jLabelBackGround = new JLabel(imageIconBackGround);
        //设置大小和位置
        jLabelBackGround.setBounds(40, 40, 508, 560);
        //把组件添加到界面中
        this.getContentPane().add(jLabelBackGround);
    }

    public void initialJMenu() {
        //创建菜单
        JMenuBar jMenuBar = new JMenuBar();

        //创建选项
        JMenu jMenu1 = new JMenu("功能");
        JMenu jMenu2 = new JMenu("关于我们");
        JMenu jMenu3 = new JMenu("重新游戏");

        //创建选项条目，在成员变量位置定义了

        //逐层添加
        //第1层添加
        jMenu1.add(jMenu3);
        jMenu1.add(jMenuItem5);
        jMenu1.add(jMenuItem6);
        jMenu2.add(jMenuItem7);
        jMenu3.add(jMenuItem1);
        jMenu3.add(jMenuItem2);
        jMenu3.add(jMenuItem3);

        //第2层添加
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        //第3层添加，相当于给整个界面设置菜单
        this.setJMenuBar(jMenuBar);

        //给选项添加监听
        jMenuItem1.addActionListener(this);
        jMenuItem2.addActionListener(this);
        jMenuItem3.addActionListener(this);
        jMenuItem5.addActionListener(this);
        jMenuItem6.addActionListener(this);
        jMenuItem7.addActionListener(this);

    }

    //创建随机数组的方法，生成一个（包含0-15随机数组）
    public int[] randomArr(int[] winarr) {
        Random r = new Random();
        int temp;
        for (int i = 0; i < winarr.length; i++) {
            int index = r.nextInt(16);
            temp = winarr[i];
            winarr[i] = winarr[index];
            winarr[index] = temp;
        }
        for (int i = 0; i < winarr.length; i++) {
            if (winarr[i] == 0)
                x = i;
        }
        System.out.println("当前的随机数组0的索引：" + x);
        return winarr;
    }


    /*
    方法重载
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 65) {
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
        }//A键按压提示原图
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (Arrays.equals(arr, winarr1)) {
            return;
        } else {
            if (keyCode == 37) {
                if (x % 4 == 3) {
                    return;
                } else {
                    int change = arr[x + 1];
                    arr[x + 1] = arr[x];
                    arr[x] = change;
                    x = x + 1;
                    //System.out.println("向左之后的空白图片索引" + x);
                    step++;
                    initialImage();
                }

            }//向左移动
            if (keyCode == 38) {
                if (x > 12) {
                    return;
                } else {
                    int change = arr[x + 4];
                    arr[x + 4] = arr[x];
                    arr[x] = change;
                    x = x + 4;
                    //System.out.println("向上之后的空白图片索引" + x);
                    step++;
                    initialImage();
                }

            }//向上移动
            if (keyCode == 39) {
                if (x % 4 == 0) {
                    return;
                } else {
                    int change = arr[x - 1];
                    arr[x - 1] = arr[x];
                    arr[x] = change;
                    x = x - 1;
                    //System.out.println("向右之后的空白图片索引" + x);
                    step++;
                    initialImage();
                }

            }//向右移动
            if (keyCode == 40) {
                if (x < 4) {
                    return;
                } else {
                    int change = arr[x - 4];
                    arr[x - 4] = arr[x];
                    arr[x] = change;
                    x = x - 4;
                    //System.out.println("向下之后的空白图片索引" + x);
                    step++;
                    initialImage();
                }

            }//向下移动
            if (keyCode == 65) {
                initialImage();
            }//A键释放之后会到原始状态
            if (keyCode == 87) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = winarr1[i];
                }
                x = 15;
                step++;
                initialImage();
            }//W键通关
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == jMenuItem1){
            int girlrandom = r.nextInt(13) + 1;
            path = "day16\\image\\girl\\girl" + girlrandom + "\\";
            arr = randomArr(winarr);
            step = 0;
            initialImage();
        }//美女
        if(source == jMenuItem2){
            int animalrandom = r.nextInt(8) + 1;
            path = "day16\\image\\animal\\animal" + animalrandom + "\\";
            arr = randomArr(winarr);
            step = 0;
            initialImage();
        }//动物
        if(source == jMenuItem3){
            int sportrandom = r.nextInt(10) + 1;
            path = "day16\\image\\sport\\sport" + sportrandom + "\\";
            arr = randomArr(winarr);
            step = 0;
            initialImage();
        }//运动
        if(source == jMenuItem5){
            this.setVisible(false);
            new LoginJFrame();
        }//重新登录
        if(source == jMenuItem6){
            System.exit(0);
        }//关闭游戏
        if(source == jMenuItem7){
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //给弹框设置大小
            jDialog.setSize(344,344);
            //创建图片
            ImageIcon imageIconUs = new ImageIcon("day16\\image\\about.png");
            //放在JLable的容器中
            JLabel jLabelUs = new JLabel(imageIconUs);
            jLabelUs.setBounds(0,0,258,258);
            //把图片放置到弹框当中
            jDialog.getContentPane().add(jLabelUs);
            //弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //不关闭弹窗其他无法显示
            jDialog.setModal(true);
            //显示弹框
            jDialog.setVisible(true);
        }//公众号
    }
}

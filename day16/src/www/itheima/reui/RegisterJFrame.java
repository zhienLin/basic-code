package www.itheima.reui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static www.itheima.reui.LoginJFrame.userlist;

public class RegisterJFrame extends JFrame implements ActionListener {
    //按钮
    JButton OK = new JButton();
    JButton reset = new JButton();
    //文本框
    JTextField repassword = new JTextField();
    JTextField password = new JTextField();
    JTextField username = new JTextField();
    User userregister = new User();


    public RegisterJFrame() {
        initialRegisterJFrame();
        initializeImage();
    }

    public void initializeImage() {
        //清除之前的图像界面
        this.getContentPane().removeAll();
        //1.1注册用户名
        ImageIcon iconusername = new ImageIcon("day16\\image\\register\\注册用户名.png");
        JLabel jLabelsername = new JLabel(iconusername);
        jLabelsername.setBounds(125, 135, 79, 17);
        this.getContentPane().add(jLabelsername);
        //1.2注册用户名文字框
        username.setBounds(225, 134, 200, 30);
        this.getContentPane().add(username);


        //2.1密码
        ImageIcon iconpassword = new ImageIcon("day16\\image\\register\\注册密码.png");
        JLabel jLabelpassword = new JLabel(iconpassword);
        jLabelpassword.setBounds(125, 195, 64, 16);
        this.getContentPane().add(jLabelpassword);
        //2.2密码对话框
        password.setBounds(225, 195, 200, 30);
        this.getContentPane().add(password);

        //3.1确认密码
        ImageIcon iconverifycode = new ImageIcon("day16\\image\\register\\再次输入密码.png");
        JLabel jLabelverifycode = new JLabel(iconverifycode);
        jLabelverifycode.setBounds(125, 256, 96, 17);
        this.getContentPane().add(jLabelverifycode);
        //3.3确认密码对话框
        repassword.setBounds(225, 256, 200, 30);
        this.getContentPane().add(repassword);


        //4.1添加登录按钮
        OK.setBounds(123, 310, 128, 47);
        OK.setIcon(new ImageIcon("day16\\image\\register\\注册按下.png"));
        //4.2去除按钮的默认边框
        OK.setBorderPainted(false);
        //4.3去除按钮的默认背景
        OK.setContentAreaFilled(false);
        this.getContentPane().add(OK);
        //登录按钮监听器
        OK.addActionListener(this);

        //5.1添加注册按钮
        reset.setBounds(256, 310, 128, 47);
        reset.setIcon(new ImageIcon("day16\\image\\register\\重置按下.png"));
        //5.2去除按钮的默认边框
        reset.setBorderPainted(false);
        //5.3去除按钮的默认背景
        reset.setContentAreaFilled(false);
        this.getContentPane().add(reset);
        //注册按钮监听器
        reset.addActionListener(this);


        //6添加背景图片
        ImageIcon iconbackground = new ImageIcon("day16\\image\\register\\background.png");
        JLabel jLabelbackground = new JLabel(iconbackground);
        jLabelbackground.setBounds(0, 0, 470, 390);
        this.getContentPane().add(jLabelbackground);

        //界面显示
        this.getContentPane().repaint();


    }

    public void initialRegisterJFrame() {
        this.setSize(488, 450);
        //设置界面的标题
        this.setTitle("拼图 注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //让显示显示出来，建议写在最后
        this.setVisible(true);
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == OK) {
            if (password.getText().equals(repassword.getText())) {
                userregister.setName(username.getText());
                userregister.setPassword(password.getText());
                if(addCheck() == 1){
                    userlist.add(userregister);
                    showJDialog("添加成功");
                    this.setVisible(false);
                    new LoginJFrame();
                }else if (addCheck() == 0){
                    showJDialog("该用户名已近存在，请您重新输入");
                    username.setText("");
                    password.setText("");
                    repassword.setText("");
                }else {
                    showJDialog("请您先输用户名");
                }
            }else
                showJDialog("两次密码输入不一致");
        } else if (source == reset) {
            username.setText("");
            password.setText("");
            repassword.setText("");
        }

    }

    public int addCheck() {
        int flag = 1;
        if (userregister.getName().length() != 0) {
            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).getName().equals(userregister.getName())) {
                    flag = 0;
                    break;
                }
            }
        }
        else {
            flag = -1;
        }
        return flag;
    }


}




package www.itheima.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RunTimePracticeJFrame extends JFrame implements ActionListener {

    JButton jButton1 = new JButton("帅爆了");
    JButton jButton2 = new JButton("一般般啦");
    JButton jButton3 = new JButton("不帅，有点难看");
    JButton jButton4 = new JButton("饶了我吧");

    public RunTimePracticeJFrame(){
        initialJFrame();
        initialImage();

    }

    public void initialJFrame() {
        this.setTitle("颜值测评");
        this.setSize(400, 700);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
    public void initialImage() {
        JLabel jLabel = new JLabel("你觉得自己帅吗");
        jLabel.setBounds(150,0,100,50);
        this.getContentPane().add(jLabel);

        jButton1.setBounds(150,70,100,100);
        this.getContentPane().add(jButton1);
        jButton1.addActionListener(this);

        jButton2.setBounds(150,180,100,100);
        this.getContentPane().add(jButton2);
        jButton2.addActionListener(this);

        jButton3.setBounds(150,290,100,100);
        this.getContentPane().add(jButton3);
        jButton3.addActionListener(this);

        jButton4.setBounds(150,400,100,100);
        this.getContentPane().add(jButton4);
        jButton4.addActionListener(this);

    }


    public void showDialog(String content){
        JDialog dialog = new JDialog();
        dialog.setSize(200,200);
        dialog.setModal(true);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);

        JLabel jLabelcontent = new JLabel(content);
        jLabelcontent.setBounds(0,0,100,100);
        dialog.getContentPane().add(jLabelcontent);

        dialog.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == jButton1){
            try {
                Runtime.getRuntime().exec("shutdown -s -t 3600");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            showDialog("电脑将在一小时后自动关机");
        } else if (source == jButton2){
            System.out.println(" 222");
        } else if (source == jButton3){
            System.out.println(" 333");
        } else if (source == jButton4){
            try {
                Runtime.getRuntime().exec("shutdown -a");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            showDialog("电脑取消自动关机");
        }

    }
}

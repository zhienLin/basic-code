package CreateSecurity;

/**
 * 使用同步方法解决继承Thread类方式中的线程安全问题
 *
 * @author zzy
 * @date 2022-10-10 20:50
 */
public class WindowTest2 {
    public static void main(String[] args) {
        window1 w1 = new window1();
        window1 w2 = new window1();
        window1 w3 = new window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }


}

class window1 extends Thread{
    private static int ticket = 10;//必须声明成静态的，那么这个值就是这个类所有了

    @Override
    public void run() {
        while(true){
            method();
        }

    }

    public static synchronized void method() {//同步监视器：window1.class
        if (ticket > 0)
            System.out.println(Thread.currentThread().getName() + "剩余的票数为：" + ticket--);
    }
}
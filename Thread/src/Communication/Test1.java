package Communication;

import java.util.Date;

/**
 * 线程通信的例子:使用两个线程打印1-100。线程1，线程2交替打印
 * 涉及到的三个方法:
 * 1.wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * 2.notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait,
 * 就唤醒优先级高的
 * 3.notifyALL():一旦执行此方法，就会唤醒所有被wait的线程。
 * <p>
 * >wait().notify()， notifyALL()三个方法必须使用在同步代码块或同步方法中。
 * >wait().notify()， notifyALL()三个方法的调用者必须是同步代码块或
 * 同步方法中的同步监视器,否则会出现异常。
 * >wait(),notify(),notifyALL()三个方法是定义在java.Lang.Object类中.并不是Thread所特有的
 * 因为任何一个对象都可以充当同步监视器，那么任何一个对象斗可以去调用这三个方法，那么就应该定义在
 * object的类当中，方便任何一个对象去调用。
 *
 * 面试题: sLeep()和wait()的异同?
 * 1.相同点:一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点:
 * 1）两个方法声明的位置不同:Thread类中声明sLeep() , object类中声明wait()
 * 2）调用的要求不同: sLeep()可以在任何需要的场景下调用。wait()必须使用在同步代
 * 3）关于是否释放同步监视器:如果两个方法都使用在同步代码块或同步方法中，sLeep()不会释放锁，wait()会释放锁
 *
 * @author zzy
 * @date 2022-10-11 21:39
 */
public class Test1 {
    public static void main(String[] args) {
        PrintNum pn = new PrintNum();

        Thread t1 = new Thread(pn);
        Thread t2 = new Thread(pn);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class PrintNum implements Runnable {

    private int num = 0;

    Object ob = new Date();
    @Override
    public void run() {
        while (true) {
            synchronized (ob) {
                ob.notify();
                if (num < 100) {
                    num++;
                    System.out.println(Thread.currentThread().getName() + "输出" + num);
                    try {
                        ob.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else
                    break;
            }
        }
    }
}
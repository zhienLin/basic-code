/**
 * 一共有两种实现的方法
 * 1.创建三个线程类的对象，但是他们的票的属性是静态的，也就是归类所有，因此该类的所有实现类对象都共有这样一个属性
 * 2.创建一个实现Runnable()接口的类，在run方法中去定义这个买票的规则，然后创建线程去实现这个Runnale()的方法，
 * 这样就会三个线程同意去调用这个类，因此也实现了共享当前票数的效果。
 * 创建三个窗口去买票，总票数是100张
 *
 *
 * 比较创建线程的两种方式：
 * 开发中优先选择实现Runnable()接口实现的方式
 * 原因: 1．实现的方式没有类的单继承性的局限性
 *      2.实现的方式更适合来处理多个线程有共享数据的情况。
 *
 * 两种方式的联系：
 * Thread类也实现了Runnable()的接口，相当于也重写了Runnable()的接口的run()方法。
 * 那么我们创建的Thread的实现类也相当于重写了Runnable()的接口的run()方法。
 * 还有就是直接实现Runnable()的接口，直接实现run()方法。
 *
 *
 *
 * Java中的线程分为两类:一种是守护线程，一种是用户线程。
 * 它们在几乎每个方面都是相同的，唯一的区别是判断JVM何时离开。守护线程是用来服务用户线程的，通过在start()方法前调用
 * thread.setDaemon(true)可以把一个用户线程变成一个守护线程。Java垃圾回收就是一个典型的守护线程。
 * 若JVM中都是守护线程，当前JVM将退出。
 * 形象理解:兔死狗烹，鸟尽弓藏
 * @author zzy
 * @date 2022-10-10 11:43
 */
package CreateSecurity;
public class WindowTestWay2 {
    public static void main(String[] args) {

/*        window w1 = new window();
        window w2 = new window();
        window w3 = new window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();*/


        windowRunnable w1 = new windowRunnable();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window extends Thread{
    private static int ticket = 10;//必须声明成静态的，那么这个值就是这个类所有了

    @Override
    public void run() {
        while(true){
            if(ticket>0)
                System.out.println(Thread.currentThread().getName()+"剩余的票数为："+ticket--);
            else
                break;
        }

    }
}

class windowRunnable implements Runnable{
    private int ticket =  100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0)
                System.out.println(Thread.currentThread().getName()+"剩余的票数为："+ticket--);
            else
                break;
        }
    }
}


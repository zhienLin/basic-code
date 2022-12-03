package CreateSecurity;

/**
 * 多线程的创建，
 * 方式一:继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run() -->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.过此对象调用start(), 作用：1.启动当前的线程 2.调用当前类的run()方法。
 *
 * @author zzy
 * @date 2022-10-08 21:47
 */


class MyThread extends Thread {
    @Override
    public void run() {
        //输出100以内的偶数,run()中存放要实现的操作
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName()+i+"");
        }
    }
}

public class ThreadTestWay1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        //start的方法有两个作用：1.启动当前的线程 2.调用当前类的run()方法。
        mt.start();//在这之前都是主线程在起作用，这之后才是两个线程一起。
        mt.start();//不可以让已经启动的程序去执行，因为这里已经启动的程序的线程状态不是0，
        //那么就会报IllegalThreadStateException的错误。

        //如果直接调用run()方法他的线程就只是在主线程中进行的，而不会产生一个新的线程。
        //mt.run();//线程的名字是main()


        //以下仍然是在主线程中进行的
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"*****************");
        }
    }
}

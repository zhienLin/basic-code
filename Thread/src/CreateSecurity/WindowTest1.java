package CreateSecurity;

/**
 *
 * *1.start():启动当前线程;调用当前线程的run()
 * * 2. run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中* 3. currentThread():静态方法，返回执行当前代码的线程
 * *4. qetName():获取当前线程的名字
 * *5. setName():设置当前线程的名字* 6. yieLd()∶释放当前cpu的执行权
 * * 7.join():在线程α中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
 * *8.stop():已过时。当执行此方法时，强制结束当前线程。
 * * 9. sleep(long millitime):让当前线程*睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
 * *1e. isAlive():判断当前线程是否存活
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @author zzy
 * @date 2022-10-10 20:50
 */
public class WindowTest1 {
    public static void main(String[] args) {
        windowRunnable1 w1 = new windowRunnable1();

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

class windowRunnable1 implements Runnable {
    private int ticket = 20;

    @Override
    public void run() {
        while (true) {
            method();
            }
        }

    public synchronized void method() {//this 就是同步监视器 这里就是默认的
            if (ticket > 0)
                System.out.println(Thread.currentThread().getName() + "剩余的票数为：" + ticket--);
    }
}

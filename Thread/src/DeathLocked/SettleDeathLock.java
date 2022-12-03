package DeathLocked;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全新方法三：
 * Lock(锁)
 * 从JDK 5.0开始，Java提供了更强大的线程同步机制——通过显式定义同步锁对象来实现同步。
 * 同步锁使用Lock对象充当。
 * java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。
 * 锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程共享资源之前应先获得Lock对象。
 * ReentrantLock类实现了Lock，它拥有与synchronized 相同的并发性和内存语义，
 * 在实现线程安全的控制中，比较常用的是ReentrantLock，可以显式加锁、释放锁。
 *
 * 1.面试题：synchronized 和 lock 的异同
 * >相同：二者都可以解决线程安全的问题
 * >不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 * Lock需要手动的启动同步(Lock())，同时结束同步也需要手动的实现(unLock())
 *
 * 2.lock锁的优点：
 * ①Lock是显式锁（手动开启和关闭锁，别忘记关闭锁），synchronized是隐式锁，出了作用域自动释放
 * ②Lock只有代码块锁，synchronized有代码块锁和方法锁
 * ③使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）
 * lock -->同步代码块 --> 同步方法
 * @author zzy
 * @date 2022-10-11 20:09
 */
public class SettleDeathLock {
    public static void main(String[] args) {
        window w = new window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}

class window implements Runnable {
    private int ticket = 100;
    //这个构造的方法主要有两种形式：有参和无参，无参的时候默认就是false,也就是这个时候并不公平
    //如果是有参的true,那么这个时候线程进入的顺序就是公平的。也就是一共有当一个线程在握锁的时候
    //如果有其他的线程进来等待，那么当他释放锁的时候是按照先后的顺序进行握锁的。
    //但是不公平的情况是不管线程等待的先后顺序的

    //1.实例化一个对象
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                //2.调用锁定方法
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "剩余的票数为：" + ticket);
                    ticket--;
                } else
                    break;
            } finally {
                //3.调用解锁方法
                lock.unlock();
            }


        }
    }
}
package CreateSecurity;

/**
 * *
 *1.问题:卖票过程中，出现了重票、错票-->出现了线程的安全问题
 *2.问题出现的原因:当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 *3.如何解决：当一个线程在操作共享数据的时候，其他线程不能参与进来，直到线程A操作完共享数据的时候
 * 其他的线程才可以开始操作共享数据。这种情况即使线程A出现了阻塞，也不能被改变。
 *4.在Java中，同各国同步机制解决安全问题
 * 最初的方式一：同步代码块 synchronized(同步监视器){需要被同步的代码（操作共享数据的代码）}
 * 共享数据：多个线程共同操作的数据
 * 同步监视器：俗称为“锁”，谁进去谁就能拿到这个锁，任何一个对象都能充当锁。
 * 要求多个线程必须用同一个锁，如果不是同一个锁还是会出现问题。
 *在实现Runnable接口创建多线程的方式中，我们可以考虚使用this充当同步监视器。
 *在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 *最初的方式二：同步方法
 *    如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 *关于同步方法的总结:
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 * 2.非静态的同步方法，同步监视器是:this。 静态的同步方法，同步监视器是:当前类本身。
 *
 *
 * 同步的方式，解决了线程的安全问题。---好处
 * 操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。 ---局限性
 *
 * 比如票出现-1的情况，就是当某一个线程进来获取到当前的票数的时候，别的线程也进来了，那么此时别的线程会对
 * 这个票数减1，然后在回到之前的那个线程的时候，票数在接着减1，这就是-1出现的原因。
 *
 * 重票出现的原因：都没减呢，就有进来的
 *
 * @author zzy
 * @date 2022-10-10 17:24
 */
public class SecurityThread {
    public static void main(String[] args) {
        Thread1 w1 = new Thread1();
        Thread1 w2 = new Thread1();
        Thread1 w3 = new Thread1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w2.start();
        w1.start();
        w3.start();
    }
}
class Thread1 extends Thread {
    private static int ticket = 20;//必须声明成静态的，那么这个值就是这个类所有了
    static Object ob = new Object();

    @Override
    public void run() {
        while(true) {
            //synchronized (ob) {
            //因此可以知道，类也是对象。因为window只会加载一次，因此window.class就是一个
            synchronized (Thread1.class) {
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
            }
        }

    }

}
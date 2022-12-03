package CreateSecurity;

/**
 * 1.测试Thread中的常用方法:
 * start()∶启动当前线程;调用当前线程的run()
 * run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * currentThread()∶静态方法，返回执行当前代码的线程
 * getName():获取当前线程的名字
 * setName():设置当前线程的名字yield():释放当前cpu的执行权
 * yeild():切换CPU的主动权,但是主动权也有可能重新回到当前线程。
 * join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才
 * 结束阻塞状态。//一般用于当前线程达到某种条件的时候，需要使用线程b的某些数据
 * stop()已经过时，主要是强制结束当前的线程
 * sleep(long millitime),让当前的线程“睡眠”指定的毫秒数。阻塞当前的进程，可以用于倒计时，比如新年的时候你
 * isAlive() 判断当前线程是否存活
 * 如果有的线程只使用一次，那么可以使用匿名内部类的形式
 * Thread的子类在重写run()，run()中出现任何异常只能用try-catch的方法，
 * 因为Thread()的run()方法没有抛出EXCEPTION，所以其子类也不能抛出
 * 说明:高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下被执行
 * 并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 *
 *线程的优先级:
 * MAX PRIDbRITY: 10
 * MIN_PRIORITY: 1
 * NORM_PRIORITY: 5
 *获取优先级：get
 * @author zzy
 * @date 2022-10-10 08:46
 */
public class ThreadBasisCode {
    public static void main(String[] args) {

        MyThread1 my = new MyThread1("MyThread");
        my.setPriority(Thread.MAX_PRIORITY);
        my.start();
        //my.setName("xixi");

/*        new Thread(){
            public void run(){
                for (int i = 1; i <= 100; i++) {
                    if( i%2 == 0)
                        System.out.println(Thread.currentThread()+":"+i);
                }

            }

        }.start();*/

/*        new Thread(){
            public void run(){
                for (int i = 1; i <= 100; i++) {
                    if( i%2 != 0)
                        System.out.println(Thread.currentThread()+":"+i);
                }
            }

        }.start();*/


        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if(i%2!= 0) {
                System.out.println(Thread.currentThread().getName()+":"+i+"*"+Thread.currentThread().getPriority());
                //String s = Thread.currentThread().getName();
                //System.out.println(s);
            }
/*            if(i%20 == 0)
            //this.yield();
            {
                try {
                    my.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/


        }

        //boolean alive = my.isAlive();
        //System.out.println(alive);


    }
}

class MyThread1 extends Thread {
    public MyThread1(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if( i%2 == 0)
                System.out.println(Thread.currentThread().getName()+":"+i+"*"+Thread.currentThread().getPriority());
            //if(i%20 == 0)
                //this.yield();


        }
    }

}


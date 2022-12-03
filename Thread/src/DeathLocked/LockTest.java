package DeathLocked;

import java.util.concurrent.locks.ReentrantLock;

/***银行有一个账户。
 *有两个储户分别向同一个账户存3000元,每次存1000,存3次。每次存完打印账户余额。
 *
 * 两个储户的线程
 * 有共享数据，是余额
 * 是否有线程安全的问题？有，两个账户同时共享数据
 * 如何解决线程安全问题？三种方式
 * @author zzy
 * @date 2022-10-11 20:51
 */
public class LockTest {
    public static void main(String[] args) {

        Account a = new Account("zzy",6408);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        Thread t3 = new Thread(a);
        t1.setName("老张");
        t2.setName("丫姐");
        t3.setName("哥哥");

        t1.start();
        t2.start();
        t3.start();
    }



}

class Account implements Runnable {

    private String name;
    private int num;
    private ReentrantLock rl = new ReentrantLock(true);

    public Account() {
    }

    public Account(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public void add(int add) {
        num = num + add;
       System.out.println(Thread.currentThread().getName()+"向"+name+"的账户打钱，"+name+"的账户余额为："+num);
    }

    @Override
    public void run() {
        rl.lock();
        while(num < 1000000000) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            add(100000000);
        }
        rl.unlock();
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }


    public String toString() {
        return "Account{name = " + name + ", num = " + num + ", rl = " + rl + "}";
    }
}
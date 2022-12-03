package Communication;

/**
 * @author zzy
 * @date 2022-10-12 10:32
 */
public class ZzyTryThread {
    public static void main(String[] args) {
        Clerk2 c = new Clerk2(0);
        P P = new P(c);
        C c1 = new C(c);
        P.start();
        c1.start();
    }
}


class Clerk2{
    private int count;

    public Clerk2() {
    }

    public Clerk2(int count) {
        this.count = count;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return "Clerk2{count = " + count + "}";
    }
}

class P extends Thread{
    private Clerk2 c;

    public P() {
    }

    public P(Clerk2 c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (c) {
                int count = c.getCount();
                if (count < 20) {
                    System.out.println("正在生产第" + (++count) + "个产品");
                    c.setCount(count);
                    c.notify();
                } else {
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class C extends Thread{
    private Clerk2 c;

    public C() {
    }

    public C(Clerk2 c) {
        this.c = c;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (c) {
                int count = c.getCount();
                if (count > 0) {
                    System.out.println("正在消费第" + count + "个产品");
                    c.setCount(--count);
                    c.notify();
                } else {
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

//思路分析：
// 生产者和消费者是两个线程，并且共享一个数据，也就是店员手中的库存。
// 消费者要去消费，那么它的run()方法里面就必须有一个消费的行为；
// 生产者要去生产，那么它的run()方法里面就必须有一个生产的行为；
// 但是生产和消费必须握同一把锁，也就是当前的店员对象。这样才能实现线程安全的问题。
// 每次达到临界的状态，就要进行wait()。但是一旦消费者消费/生产者生产，另外一个线程就进行锁的释放。
// 所以1.创建两个线程的对象，并且传递一个共同的店员的对象
// 这个sleep()的函数最好放在while()之后，上锁之前，这样别的线程才有可能进来
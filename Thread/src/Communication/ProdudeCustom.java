package Communication;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:10），如果生产者试图生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产;
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 有两个线程：生产者与消费者
 * 有共享数据：产品
 * 会产生线程安全的问题
 *
 * @author zzy
 * @date 2022-10-12 08:14
 */
public class ProdudeCustom {
    public static void main(String[] args) {
        Clerk1 cl = new Clerk1(0);
        Producer p = new Producer(cl);
        Consumer c = new Consumer(cl);
        p.setName("桃李");
        c.setName("zzy");
        p.start();
        c.start();
    }
}

class Clerk1 {
    private int count;

    public Clerk1() {
    }

    public Clerk1(int count) {
        this.count = count;
    }


    public synchronized void prodece() {
        if(count<20){
            count++;
            notify();
            System.out.println(Thread.currentThread().getName()+"正在生产第"+count+"个产品");
            //System.out.println("库存是："+count);
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consum() {
        if(count>0){
            System.out.println(Thread.currentThread().getName()+"正在消费第"+count+"个产品");
            count--;
            notify();
            //System.out.println("库存是："+count);
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
        return "Clerk1{count = " + count + "}";
    }
}

class Producer extends Thread {
    private Clerk1 c;

    public Producer() {
    }

    public Producer(Clerk1 c) {
        this.c = c;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在生产...");
        while(true) {
            c.prodece();
        }
    }

    /**
     * 获取
     * @return c
     */
    public Clerk1 getC() {
        return c;
    }

    /**
     * 设置
     * @param c
     */
    public void setC(Clerk1 c) {
        this.c = c;
    }

    public String toString() {
        return "Producer{c = " + c + "}";
    }
}

class Consumer extends Thread {
    private Clerk1 c;

    public Consumer() {
    }

    public Consumer(Clerk1 c) {
        this.c = c;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在消费...");
        while(true) {
            c.consum();
        }
    }

    /**
     * 获取
     * @return c
     */
    public Clerk1 getC() {
        return c;
    }

    /**
     * 设置
     * @param c
     */
    public void setC(Clerk1 c) {
        this.c = c;
    }

    public String toString() {
        return "Consumer{c = " + c + "}";
    }
}

//思路分析：
// 生产者和消费者是两个线程，并且共享一个数据，也就是店员手中的库存。
// 消费者要去消费，那么它的run()方法里面就必须有一个消费的行为；
// 生产者要去生产，那么它的run()方法里面就必须有一个生产的行为；
// 但是生产和消费必须握同一把锁，也就是当前的店员对象。这样才能实现线程安全的问题。
// 每次达到临界的状态，就要进行wait()。但是一旦消费者消费/生产者生产，另外一个线程就进行锁的释放。
//所以1.创建两个线程的对象，并且传递一个共同的店员的对象
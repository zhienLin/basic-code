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
public class ProdudeCustomMy {
    public static void main(String[] args) {
        Clerk c = new Clerk(5);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.setName("桃李");
        t2.setName("zzy");

        t1.start();
        t2.start();
    }
}


class Clerk implements Runnable {
    private int stock;

    public Clerk() {
    }

    public Clerk(int stock) {
        this.stock = stock;
    }


    @Override
    public void run() {
        String str = Thread.currentThread().getName();
        while(true) {
            synchronized (this) {
                if(stock > 0 && stock < 20) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notify();
                    if (stock > 0 && stock < 10) {
                    if (str == "桃李") {
                        stock = stock + 1;
                        System.out.println(Thread.currentThread().getName() + "生产了一个面包，当前库存是" + stock);
                    } else if (str == "zzy") {
                        stock = stock - 1;
                        System.out.println(Thread.currentThread().getName() + "买了一个面包，当前库存是" + stock);
                    }
                }
                else
                    break;

               } else if (stock == 20) {
                    if (str == "zzy") {
                        stock = stock - 1;
                        System.out.println(Thread.currentThread().getName() + "买了一个面包，当前库存是" + stock);
                    } else {
                        try {
                            wait();
                            System.out.println("桃李不允许生产面包");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (stock == 0){
                    if (str == "桃李") {
                        stock = stock + 1;
                        System.out.println(Thread.currentThread().getName() + "生产了一个面包，当前库存是" + stock);
                    }else
                    {
                        try {
                            wait();
                            System.out.println("消费者无法购买面包");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取
     *
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * 设置
     *
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return "Clerk{stock = " + stock + "}";
    }
}
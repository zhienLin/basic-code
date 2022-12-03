package Communication;

/**
 * @author zzy
 * @date 2022-10-12 10:51
 */
public class ZzyTryRunnable {
    public static void main(String[] args) {
        //Clerk2 c = new Clerk2(0);
        PC p = new PC(10);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.setName("桃李");
        t2.setName("zzy");
        t1.start();
        t2.start();
    }
}

class PC implements Runnable {

    private int num;


    @Override
    public void run() {
        String name = Thread.currentThread().getName();


        while (true) {
            if (name == "桃李") {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(this){
                if (num < 20) {
                    num++;
                    notify();
                    System.out.println("生产第" + num);
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }} else if (name == "zzy") {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    if (num > 0) {
                        System.out.println("消费第" + num);
                        num--;
                        notify();
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }

    }

    public PC() {
    }

    public PC(int num) {
        this.num = num;
    }


}
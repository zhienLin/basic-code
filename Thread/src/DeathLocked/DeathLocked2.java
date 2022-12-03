package DeathLocked;

/**
 * @author zzy
 * @date 2022-10-11 19:41
 */
public class DeathLocked2 implements Runnable{
        A a = new A();
        B b = new B();
    public static void main(String[] args) {
        DeathLocked2 dl = new DeathLocked2();
        Thread t = new Thread(dl);
        t.start();//分线程
        dl.init();//主线程
    }

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }
}

class A {
    public synchronized void foo(B b) {
        System.out.println("当前线程名:" + Thread.currentThread().getName() +
                "进入了A实例的foo方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("当前线程名: " + Thread.currentThread().getName()
                        +"企图调用B实例的last方法");
                b.last();//last是上了b个类的锁
    }
    public synchronized void last() {
        System.out.println("进入了A类的last方法内部");
    }
}

class B {
    public synchronized void bar(A a) {
        System.out.println("当前线程名:" + Thread.currentThread().getName() +
                "进入了B实例的bar方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("当前线程名: " + Thread.currentThread().getName()
                +"企图调用A实例的last方法");
        a.last();//last是上了a这个类的锁
    }

    public synchronized void last() {
        System.out.println("进入了B类的last方法内部");
    }
}
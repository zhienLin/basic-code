package CreateSecurity;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个Runnable接口的类
 * 2.实现类去实现Runnable()中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 * @author zzy
 * @date 2022-10-10 15:39
 */
public class ThreadCreate {
    public static void main(String[] args) {
        RunThread rt = new RunThread();
        Thread t = new Thread(rt);
        //通过Thread类的对象调用start() 1:启动当前的线程，2:调用当前线程的run()
        t.start();
        //但是这里其实是调用了RunThread里面的run(),因为start()的方法会先去检测有没有Runnable类的对象
        //如果有的话就进行调用Runnable对象的run()
    }



}
class RunThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0)
                System.out.println(i);
        }
    }
}
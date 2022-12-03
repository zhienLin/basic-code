package JDK5Add;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口的方式创建多线程更强大？
 * 1.call()有返回值
 * 2.calL()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3.CaLLabLe是支持泛型的
 * @author zzy
 * @date 2022-10-12 11:23
 */
public class Callable1 {
    public static void main(String[] args) {
        //3.创建一个实现Callable的对象
        NumThread nt = new NumThread();
        //4.将此Callable的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask <Integer> ft = new FutureTask(nt);//
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并start()
        new Thread(ft).start();//因为FutureTask本身就是实现了Runnable()的方法
        try {
            //获取返回值
            Integer o = ft.get();//get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//创建一个实现Callable接口的类
class NumThread implements Callable <Integer>{

    //重写抽象方法
    @Override
    public Integer call() throws Exception {
        int sum =0;
        for (int i = 1; i <= 100; i++) {
            if(i%2 ==0){
                sum += i;
            }
        }
        return sum;
    }
}
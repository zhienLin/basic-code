package JDK5Add;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 背景:经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大。
 * 思路:提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。
 * 可以避免频繁创建销毁、实现重复利用。类似生活中的公共交通工具。
 * 好处:
 * >提高响应速度(减少了创建新线程的时间)
 * >降低资源消耗（重复利用线程池中线程，不需要每次都创建)
 * >便于线程管理
 * >corePoolSize:核心池的大小maximumPoolSize:最大线程数
 * >√keepAliveTime:线程没有任务时最多保持多长时间店会终√ ...
 * @author zzy
 * @date 2022-10-12 15:12
 */
public class ThreadPool {
    public static void main(String[] args) {

        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //ExecutorService是一个接口，但是一般接口是没有属性值的，只有其实现类的对象才会有属性
        //也就是只有其实现类才能进行属性的设置。那么其是实现类的对象如何进行创建呢？
        //System.out.println(service.getClass());ThreadPoolExecutor

        ThreadPoolExecutor tpe = (ThreadPoolExecutor) service;//ThreadPoolExecutor是ExecutorService的一个实现类

        //设置线程池的属性
        tpe.setCorePoolSize(15);

        //2.执行指定的线程操作。需要提供实现Runnable接口或者Callable接口的实现类对象
        service.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 5 == 0)
                        System.out.println(i);
                }
            }
        });//Runnable接口使用execute的方法
        //service.submit(new NumPrint());//Callable接口使用submit的方法

        //3.关闭连接池
        service.shutdown();
    }
}
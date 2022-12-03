package www.itheima.demo;

import java.io.IOException;

public class RunTimeTest {
    public static void main(String[] args) throws IOException {
/*        //1.获取Runtime的对象，因为一个电脑只有一个运行环境。所以设置了一个Final修饰
        Runtime r1 = Runtime.getRuntime();
        //2.exit停止虚拟机
        //r1.exit(0);

        //3.获得CPU的线程数
        Runtime.getRuntime().availableProcessors();

        //4.JVM在计算机当中能够获取的最大内存(字节)
        System.out.println(Runtime.getRuntime().maxMemory() / 1024/ 1024);

        //5.JVM在计算机当中已经获取的内存(字节)
        System.out.println(Runtime.getRuntime().totalMemory()/ 1024/ 1024);

        //6.JVM在计算机当中剩余的内存(字节)
        System.out.println(Runtime.getRuntime().freeMemory()/ 1024/ 1024);*/

        //7.打开CMD命令
        //7.运行cmd命令
        //shutdown :关机
        //加上参数才能执行
        // -s ︰默认在1分钟之后关机
        //-s -t指定时间:指定关机时间
        //-a :取消关机操作
        // -r:关机并重启

        //Runtime.getRuntime().exec("shutdown -s -t 3600");//在一个小时之后关机
        Runtime.getRuntime().exec("shutdown -a");
    }
}

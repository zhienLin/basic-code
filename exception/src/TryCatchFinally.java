import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryCatchFinally {
    /*  异常的处理:抓抛模型
            过程一:"抛":程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象。
                    并将此对象抛出。一旦抛出对象以后，其后的代码就不再执行。
            过程二:"抓":可以理解为异常的处理方式: 1.try-catch-finally    2.throws

            try{
                  可能出现异常的代码
                }catch(异常类型1 变量名1){
                  处理异常的方式1
                }catch(异常类型2 变量名2){
                  处理异常的方式2
                }catch(异常类型3 变量名3){
                  处理异常的方式3
                }
                finally{
                  一定会执行的代码
                }

    说明：
         1.finally是可选的，就跟switch()里面的default一样
         2.使用try将可能出现异常的代码进行包装，然后在执行过程种，一旦出现异常，就会生成一个对应的
         异常类对象，根据此对象的类型去catch中进行匹配。
         3.一旦try中的某个异常匹配到某一个catch中的类型们就会执行其中的代码，进行异常的处理。
         一旦处理完成，就跳出当前的try-catch的结构（在没有写finally的情况下），然后继续执行后面的代码
         4.子类的异常对象应该写在父类异常的上面，不然会报错的
         5.处理异常的两种方式： 1）Sring getMessage()  2)printStackTrace();第二种常用
         6.在try里面声明的结构变量，出了try结构以后，就不能被调用了。
         7.finally中的代码是一定会被执行的，哪怕try中有return，catch中有异常或者return语句
         而且如果finally中如果有return,try或者catch中也有return语句的时候，只执行finally中的return;
         8.try-catch-finally是可以嵌套的，比如最后finally里面依然有异常的时候，也可以加catch()来处理异常。
         9.像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，
         我们需要自己手动的进行资源的释放。此时的资源释放，就需要声明在finally中。


            使用Try-catch-finally处理编译时的异常，使得程序在编译时不在报错了，但是运行的时候仍然可能会报错
            就相当于把编译阶段的问题延迟到运行的阶段。

            开发中由于运行时异常比较常见，所以我们通常不针对运行时异常编写try-catch-finally
            针对编译异常，我们一定要考虑异常处理。
            */

    @Test
    public void test() {
        String str = "abc";
        try {
            int parseInt = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String message = e.getMessage();
            System.out.println(message);
            //e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } catch (Exception e) {
            System.out.println("出现异常");
        }
        System.out.println(str);

    }

    public static void testFinally() {
        int a = 9;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("日出东方催人醒");
        }
    }


    @Test
    public void test2() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

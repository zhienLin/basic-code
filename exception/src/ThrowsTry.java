import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


//Throws只是向上抛了，但是问题并没有解决掉，最后想要解决异常还是要利用try-catch-finally的方法
//1."throws+异常类型写在方法的声明处。指明此方法执行时，可能会抛出的异常类型。
//一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，
//此对象满足throws后异常类型时，就会被抛出。异常代码后续的代码，就不再执行!

//2.如何进行两者的选择呢？
    //2.1如果父类的方法体中本身就没有用throws抛出异常，那么子类在重写该方法的时候一定是不能抛出异常的，
    //但是子类的方法如果出现异常，就必须用try-catch-finally去处理。

    //2.2执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。
    //我们建议这几个方法使用throw的方式进行处理。
    //而执行的方法a可以考虑使用try-catch-finally方式进行处理。



public class ThrowsTry {

    public static void main(String[] args) {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException {
        method1();
    }


    public static void method1() throws IOException, FileNotFoundException {
        File file = new File(" hello.txt");
        FileInputStream fis = new FileInputStream(file);
        System.out.println("1111");//未被执行
        int data = fis.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
        fis.close();
    }
}

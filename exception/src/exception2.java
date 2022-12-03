import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class exception2 {
    //分为编译异常（受检异常）和运行异常（未受检异常）
    //运行异常在编译javac的时候不会报错，而且也会生成相应的字节码文件，只有在java的时候才会报错
    //编译异常在javac的时候就会报错，根本就不会生成相应的字节码文件。
    public static void main(String[] args) {
        try {
            File file = new File(" hello.txt");
            FileInputStream fis = new FileInputStream(file);//Unhandled exception: java.io.FileNotFoundException
            int data = fis.read();//Unhandled exception: java.io.IOException
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();//Unhandled exception: java.io.IOException
            }
            fis.close();//Unhandled exception: java.io.IOException
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }//上面是下面的子类
    }

}

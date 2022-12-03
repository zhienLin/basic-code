package IOStream;

import org.junit.Test;

import java.io.*;

public class BufferStream {
    @Test
    public void bufferedStream(){

        long start = System.currentTimeMillis();

        FileInputStream fr = null;
        FileOutputStream fw = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File fRead = new File("4.jpg");
            File fWrite = new File("5.jpg");

            fr = new FileInputStream(fRead);
            fw = new FileOutputStream(fWrite);

            bis = new BufferedInputStream(fr);
            bos = new BufferedOutputStream(fw);

            byte [] buffer = new byte[10];

            int read;
            while((read = bis.read(buffer))!= -1){
                bos.write(buffer,0,read);
                //每一个处理流都有相应的flush的功能，他的作用是对缓冲的数组进行刷新
                //但是缓冲流这一种处理流的write()本身就实现了flush()的方法，因此不用再写一遍flush()的方法。
                //bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();


        System.out.println(end - start);//4 - 120


    }

    @Test
    public void bufferedRW(){
        long start = System.currentTimeMillis();

        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader bis = null;
        BufferedWriter bos = null;
        try {
            File fRead = new File("xixi.txt");
            File fWrite = new File("xixi1.txt");

            fr = new FileReader(fRead);
            fw = new FileWriter(fWrite);

            bis = new BufferedReader(fr);
            bos = new BufferedWriter(fw);

            String read;
            while((read = bis.readLine())!= null){
                bos.write(read+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();


        System.out.println(end - start);//11

    }
}






//1创建流的操作：先创建最里面的流，再去创建外层的流。
//关闭流的操作；先关闭最外层的流，再依次关闭内层的流。
//需要特别注意的是：如果关闭外层的流，那么它里面的流也会随之自动关闭，因此只需关闭最里外面的流就可以了。

//2每一个处理流都有相应的flush的功能，他的作用是对缓冲的数组进行刷新
//但是缓冲流这一种处理流的write()本身就实现了flush()的方法，因此不用再写一遍flush()的方法。
//bos.flush();

//3对于字符的缓冲流，可以是实现每次读取一整行，这个时候一整行输出的是字符串，同时也可以每次写一整行，每一整行也是字符串
//这样就会快捷很多

//缓冲流主要的作用就是提高流的读取、写入的速度，
//原因：内部提供了一个缓冲区
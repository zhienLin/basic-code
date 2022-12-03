package IOStream;

import org.junit.Test;

import java.io.*;

public class IOStream {
    /*
    一、流的分类：
            1.根据处理的数据分为：字节流（8比特），字符流（一般用来处理文本文件的，是char类型的）
            2.根据流向分为：输入流、输出流。
            3.根据流的角色分为：节点流、处理流

    二、流的体系结构：
       * 抽象基类            *节点流（直接作用在设备或者文件上的）                       *缓冲流（处理流的一类）
        InputStream          FileInputStream  (read(byte[] buffer))                  BufferedInputStream  (read(byte[] buffer))
        OutputStream         FileOutputStream (write(byte[] buffer,0,len))           BufferedOutputStream (write(byte[] buffer,0,len)) / flush()
        Reader               FileReader       (read(char[] buffer))                  BufferedReader       (read(char[] buffer)/readLine())
        Writer               FileWriter       (write(char[] buffer,0,len))           BufferedWriter       (write(char[] buffer,0,len)) / flush()

     */

    //基本的读入(写出)操作：File类的实例化 -> FileReader的实例化 -> 读入的操作  -> 数据流的关闭

    public static void main(String[] args) {
    }



    @Test
    public void testRead1() {
        FileReader fr = null;
        try {
            //1定义一个字符串，存储读出来的每一个数据
            StringBuilder sb = new StringBuilder();
            //2实例化File类的对象，指明要操作的文件
            File file = new File("xixi.txt");
            //3对特定的文件提供具体的流
            fr = new FileReader(file);
            //4数据的读入
            //所用的方法是read()的方法
            int read = fr.read();
            while (read != -1) {
                sb.append((char) read);
                read = fr.read();
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5流的关闭操作
            //原因：垃圾回收机制只回收JVM堆内存里的对象空间。
            //对其他物理连接，比如数据库连接、输入流输出流、Socket连接无能为力
            try {
                //如果在代码注释3下面出异常的话，可能没有办法创建I/O流，
                //那么没必要进行关闭，这里要进行判断
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //读入的升级
    @Test
    public void testRead2() {
        FileReader fr = null;
        try {
            File f = new File("xixi.txt");
            fr = new FileReader(f);
            //一个一个的读取太慢了，可以批量的读取，存储在一个可缓冲的数组当中
            char[] cbuf = new char[5];
            int read;
            while ((read = fr.read(cbuf)) != -1) {
                String s = new String(cbuf, 0, read);
                System.out.printf(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    //写出的操作
    @Test
    public void testWrite() {
        FileWriter fw = null;
        try {
            File f = new File("helloya");
            fw = new FileWriter(f, false);
            fw.write("最近胖了哦\n要戒掉甜食！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //文本读入+写出的复制类操作
    @Test
    public void testCope() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File fRead = new File("xixi.txt");
            File fWrite = new File("xixiCope.txt");

            fr = new FileReader(fRead);
            fw = new FileWriter(fWrite);

            char[] c = new char[10];
            int read;
            while ((read = fr.read(c)) != -1) {
                fw.write(c, 0, read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    //图片读入+写出的复制类操作
    @Test
    public void testCopeImage() {
        long start = System.currentTimeMillis();
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            File fRead = new File("4.jpg");
            File fWrite = new File("5.jpg");

            fr = new FileInputStream(fRead);
            fw = new FileOutputStream(fWrite);

            byte[] c = new byte[10];
            int read;
            while ((read = fr.read(c)) != -1) {
                fw.write(c, 0, read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);//120

    }


}

//1关于异常的处理，这里有一个十分重要的点。
//如果用throws，那么如果在创建流的时候没有出现异常，但是在读取的时候出现了异常
//那么这个时候就会向上抛出，那么流就没有办法关闭，而且真的遇到的问题也需要去上一级去解决
//所以最好用try-catch-finally.

//2还有就是流的关闭操作，如果本身流就没有创建成功，那么就没有必要进行关闭，所以要先进行空指针的判断

//3进行读入操作的时候，文件一定要存在，不然会出现FileNotFoundException的错误

//4对于升级版的读取操作
//每次返回的是读取的个数，如果到达文件的末尾，就会返回-1
//如果最后的个数没有满数组的长度，但是还有元素，那就返回剩余的元素的值
//并且【0-(剩余的元素的值-1)】被替换，但是后面的元素保持不变
//这也是为什么后面进行遍历输出的时候不能把数组全部给出，因为有一部分不满，之前的未被替换的还在数组中

//写出的一些细节
/*
从内存中写出数据到硬盘的文件里。
说明:
1．输出操作，对应的File可以不存在的。并不会报异常
2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
  File对应的硬盘中的文件如果存在:
       如果流使用的构造器是:FiLewriter(fiLe,false) / FiLewriter(file)，对原有文件进行覆盖
       如果流使用的构造器是:Filewriter(file,true):不会对原有文件覆盖，而是在原有的文件上追加内容
       这个需要跟RandomAcessFile进行一个对比，那就是RandomAcessFile不会对文件进行覆盖，但是重新添加的内容是从头开始的，
       也就是对文件的内容进行覆盖，但也只是覆盖它原有内容长度的内容。

 */

//1.对于文本文件(.txt,.java,.c ,.cpp)，使用字符流处理
//2．对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt)，使用字节流处理

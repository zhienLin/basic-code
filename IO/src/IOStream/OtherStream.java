package IOStream;

import java.io.*;
/* 其他流的使用
        *1.标准的输入、输出流
        *2.打印流
        *3.数据流
        *
        *
1.标准的输入、输出流
    1.1
    System.in:标准的输入流，默认从键盘输入。
    System.out:标准的输出流，默认从控制台输出
    1.2
    System类的setIr(InputStream is) / setout(PrintStream ps)方式重新指定输入和输出的位置;

    1.3练习:
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
    然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。

   思路：1.首先从键盘输入字符串，那么这个一定是一个基本的输入流
        2.如果利用读取到的整行的字符串可以使用BufferedRead()的readLine()的方法
        3.那么就需要利用转换流，把这个基本的输入的字节流转换为字符流

2.打印流：PrintStream,PrintWriter : 提供了一系列重载的print()和println()的方法
  如果不想输出到控制台，可以指定具体的输出的方向。详细情况见代码块2


3.数据流：DatalnputStream和Dataoutputstream
  作用:用于读取或写出基本数据类型的变量或字符串（但是没有办法搞定其他的除字符串的基本数据类型）
  将内存中的字符串、基本数据类型的变量写出到文件中。


*/

public class OtherStream {
    public static void main(String[] args) throws IOException {
/*        //1
        {
        //创建一个转换流
        InputStreamReader isr = new InputStreamReader(System.in);
        //转换为缓冲流的字符流
        BufferedReader br = new BufferedReader(isr);
        //开始整行读入数据
        while (true) {
            System.out.print("请输入：");
            String s = br.readLine();
            if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                System.out.println("程序终止");
                break;
            } else {
                String sU = s.toUpperCase();
                System.out.println(sU);
            }

        }
        br.close();
        }

        //2
        {
            //创建一个节点的输出流
            FileOutputStream fos = new FileOutputStream("F:\\JAVA\\basic_code\\IO\\xixi.txt");
            //创建一个打印流（处理流的一种）
            PrintStream out = new PrintStream(fos);
            //指定打印流的打印方式，不再向控制台输出，而是向文件输出
            if (out != null)
                System.setOut(out);

            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if (i % 50 == 0)
                    System.out.println();
            }
            out.close();

        }*/

        //3
        {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("F:\\JAVA\\basic_code\\IO\\DataStream.txt"));

            dos.writeUTF("滋榆");
            dos.writeInt(24);
            dos.writeBoolean(true);
            dos.writeChar('\n');

            dos.writeUTF("汪彤");
            dos.writeInt(23);
            dos.writeBoolean(true);
            dos.writeChar('\n');

            DataInputStream dis = new DataInputStream(new FileInputStream("F:\\JAVA\\basic_code\\IO\\DataStream.txt"));
            String s = dis.readUTF();
            System.out.print(s);
            int i = dis.readInt();
            System.out.print(i);
            boolean b = dis.readBoolean();
            System.out.print(b);
            char c = dis.readChar();
            System.out.print(c);

            dis.close();
            dos.close();

            //读取不同类型的顺序和写入的顺序要求一致
        }


    }


}



import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zzy
 * @date 2022-10-13 17:40
 */
public class TCPTest3 {

    @Test
    public void client() {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);

            //2.
            fis = new FileInputStream("仙女q.jpg");
            outputStream = socket.getOutputStream();

            //3.
            byte buffer [] = new byte[10];
            int len;
            while((len = fis.read(buffer))!=-1){
                outputStream.write(buffer,0,len);
            }
            //关闭数据的传输，也就是图片传输完成了，服务器端不用在发送数据了
            socket.shutdownOutput();

            //新增功能：接收来自服务器端的反馈,并在控制台输出
            inputStream = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte buffer1 [] = new byte[10];
            int len1;
            while((len1 = inputStream.read(buffer1))!=-1){
                baos.write(buffer1,0,len1);
            }
            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (baos != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        OutputStream outputStream = null;
        try {
            //1.
            ss = new ServerSocket(9090);
            //2.
            accept = ss.accept();
            //3.
            inputStream = accept.getInputStream();
            fos = new FileOutputStream("仙女.jpg");
            //4.
            byte buffer [] = new byte[10];
            int len;
            //read()方法其实是一个阻塞式的方法，你如果没有明确告诉我，这个方法不会退出循环
            while((len = inputStream.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            //新增功能：服务器端向客户端发送反馈
            outputStream = accept.getOutputStream();
            outputStream.write("已收到，over".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}

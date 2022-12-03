import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送一句话给服务端，服务端把信息显示子在控制台上
 * 先启动服务器端，在启动客户端
 * @author zzy
 * @date 2022-10-13 16:07
 */
public class TCPTest {

    @Test
    public void client() {
        Socket s = null;
        OutputStream outputStream = null;
        try {
            //1.这个应该是对方的IP地址，也就是服务器的，但是在这个例子下，服务器也是本机，因此是“127.0。0.1”
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            //2.建立一个Socket的对象，包含ip + 端口号；
            s = new Socket(ip,8899);
            //3.创建一个输出流，客户端要向外输出数据
            outputStream = s.getOutputStream();
            //4.写出数据
            outputStream.write("客户端向您发送给数据：天冷降温注意保暖，爱您！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.数据发送完之后，资源关闭
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(s!=null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }




    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.新建一个新的服务器端的Socket，并且只需指明自己的端口号就可以。
            serverSocket = new ServerSocket(8899);
            //2.调用accept()的方法，表示可以接受来自客户端的Socket
            accept = serverSocket.accept();
            //3.进行读入，用输入流
            inputStream = accept.getInputStream();
            //4.为了避免出现乱码的情况，这里的定义一个新的字节数组输出流

            baos = new ByteArrayOutputStream();
            System.out.println();
            byte [] buffer = new byte[5];
            int len;
            while((len=inputStream.read(buffer))!=-1){
                baos.write(buffer,0,len);//就相当于把所有的字节放进了一个新的容器足够大的字节数字中
            }
            System.out.println(baos.toString());
            System.out.println(accept.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        if (baos != null) {
            try {
                baos.close();
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
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }



    }



}

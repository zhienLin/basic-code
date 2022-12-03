import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zzy
 * @date 2022-10-13 17:20
 */
public class TCPTest2 {

    @Test
    public void client() {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream outputStream = null;

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
        }




    }



    @Test
    public void server(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
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
            while((len = inputStream.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
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
        }



    }

}

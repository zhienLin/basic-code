import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL(Uniform Resource Locator):统一资源定位符，对应着互联网的某一资源地址
 * 2.格式:
 * http://Localhost:8080/examples/beauty.jpg?username=Tom
 * 协议   主机名    端口号 资源地址            参数列表
 * 参数列表
 * @author zzy
 * @date 2022-10-14 09:30
 */
public class URLTest {
    public static void main(String[] args){
        HttpsURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //1.新建一个URL的对象
            URL url = new URL("https://pic3.zhimg.com/v2-9c42d1fcaeec1877e172f69821ff390e_r.jpg?source=1940ef5c");

            //2.建立链接关系的对象
            urlConnection = (HttpsURLConnection) url.openConnection();

            //3.开启链接
            urlConnection.connect();

            //4.创建输入流，进行资源的读入
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("InterNet\\yyqx.jpg");
            byte buffer []=new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("下载成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        urlConnection.disconnect();

        }



    }

    @Test
    public void method() throws MalformedURLException {
        URL url = new URL("https://pic3.zhimg.com/v2-9c42d1fcaeec1877e172f69821ff390e_r.jpg?source=1940ef5c");
        System.out.println(url.getProtocol());
        System.out.println(url.getPort());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getAuthority());
    }

}

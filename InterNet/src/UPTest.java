import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author zzy
 * @date 2022-10-14 08:47
 */
public class UPTest {
    @Test
    public void sender() throws IOException {


        //这个是DatagramSocket，因为主要是以包的形式发送到
        DatagramSocket ds = new DatagramSocket();

        InetAddress inetAddress = InetAddress.getByName("192.168.0.35");

        byte[] bytes = "一定要坚持!".getBytes();
        DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length,inetAddress,8090);
        ds.send(dp);
        if (ds != null) {
            ds.close();
        }

    }


}

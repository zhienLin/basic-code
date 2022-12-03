import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * 网络编程中有两个主要的问题:
 * 1.如何准确地定位网络上一台或多台主机;定位主机上的特定的应用
 * 2.找到主机后如何可靠高效地进行数据传输
 * 网络编程中的两个要素:
 * 对应问题一:IP和端口号
 * 对应问题二:提供网络通信协议:TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层)
 *
 *三、通信要素一:IP
 * 1. IP:唯一的标识Internet上的计算机(通信实体)
 * 2．在Java中使用InetAddress类代表IP
 * 3. TP分类:IPv4 和IPv6；万维网和局域网
 * 4. 域名：www.bbaiud.com   www.mi.com   www.sina.com  www.vip.com
 * 5. 本地回路地址：127.0.0.1 对应着lcocalhost
 * 6. 如何实例化InetAddress:两个方法: getByName(String host), getLocalHost()
 *    两个常用的方法：getHostName() 和 getHostAddress()
 *
 *三、通信要素一:端口号
 * 1.端口号标识正在计算机上运行的进程（程序），不同的进程有不同的端口号，比规定为一个16位的整数：0~65535.
 * 2.端口的分类： 1.公认的端口：0~1023   2.注册端口： 1024~49151  3.动态/私有端口：49152~65535
 * 3.IP + 端口号 ->网络套字：Stock
 *
 *
 *
 * TCP协议:(三次握手，四次挥手)
 * 使用TCP协议前，须先建立TCP连接，形成传输数据通道传输前，
 * 采用“三次握手”方式，点对点通信，是可靠的
 * TCP协议进行通信的两个应用进程:客户端、服务端。
 * 在连接中可进行大数据量的传输
 * 传输完毕，需释放已建立的连接，效率低
 *
 * UDP协议:
 * 将数据、源、目的封装成数据包，不需要建立连接
 * 每个数据报的大小限制在64K内
 * 发送不管对方是否准备好，接收方收到也不确认，故是不可靠的
 * 可以广播发送
 * 发送数据结束时无需释放资源，开销小，速度快
 * @author zzy
 * @date 2022-10-13 11:36
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress ia1 = InetAddress.getByName("192.168.10.14");
            System.out.println(ia1);
            InetAddress ia2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(ia2);
            InetAddress ia3 = InetAddress.getByName("127.0.0.1");//获取的是本机的地址，为了方便，又重新定义了一个新的方法。
            System.out.println(ia3);
            InetAddress ia4 = InetAddress.getLocalHost();//这个是重新定义的新获取本机的方法
            System.out.println(ia4);

            //getHostName()
            System.out.println(ia2.getHostName());

            //getHostAddress()
            System.out.println(ia2.getAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}

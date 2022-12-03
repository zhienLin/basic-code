package IOStream;

import org.junit.Test;
import java.io.*;


public class TrandStream {
/*
处理流之二:转换流的使用
    1.转换流:属于字符流(看后缀，后缀是Reader/Writer)
        InputStreamReader:将一个字节的输入流转换为字符的输入流
        OutputStreamWriter:将一个字符的输出流转换为字节的输出流
    2.作用:提供字节流与字符流之间的转换
    3．解码:字节、字节数组--->字符数组、字符串
       编码:字符数组、字符串--->字节、字节数组
    4.字符集
        ASCII:美国标准信息交换码。用一个字节的7位可以表示。
        ISo8859-1:拉丁码表。欧洲码表。用一个字节的8位表示。
        GB2312:中国的中文编码表。最多两个字节编码所有字符
        GBK:中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
        Unicode:国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节表示
        UTF-8:变长的编码方式，可用1-4个字节来表示一个字符。

    Unicode字符集只是定义了字符的集合和唯一编号，
    Unicode编码，是对UTF-8、ucS-2/UTF-16等具体编码方案的统称而已，并非具体的编码方案。
    Unicode为什么推行不了的原因：ASCALL表只用一个字节就可以进行存储，但是必须用两个字节会浪费内存。
    而且如果有的用一个，有的用两个，又该怎么样进行区分呢？




*/

//需求:综合使用转换的输入输出流，实现一个utf-8.txt文件转换为一个.gbk.txt文件

    @Test
    public void typeConversion() throws IOException {
        FileInputStream fis = new FileInputStream("xixi.txt");
        FileOutputStream fos = new FileOutputStream("hjhj.txt");
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        char [] cbuf = new char[10];
        int len;
        while((len=isr.read(cbuf))!=-1){
            osw.write(cbuf,0,len);
        }
        isr.close();
        osw.close();



    }
}

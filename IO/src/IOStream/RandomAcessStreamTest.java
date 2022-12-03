package IOStream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.Lang.0bject类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。(默认情况下，从头覆盖)
 * 也可以通过指定确定的位置(seek()的函数)进行覆盖
 * 如果想要进行追加，那么可以调用文件的长度，在seek(File.length)就可以了
 *
 * @author zzy
 * @date 2022-10-08 16:00
 */
public class RandomAcessStreamTest {
    @Test
    public void test() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("hjhj.txt", "r");
            raf2 = new RandomAccessFile("xixi1.txt", "rw");
            byte[] buffer = new byte[10];
            int length;
            while ((length = raf1.read(buffer)) != -1) {
                raf2.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFixPosition(){
        RandomAccessFile raf = null;
        try {
            File file = new File("hjhj.txt");
            raf = new RandomAccessFile(file,"rw");
            //把指针调到角标为某个数的位置，这样就不是从默认的0开始了，而是从这个数开始进行覆盖。
            raf.seek(3);
            raf.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf!=null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    实现一个插入的效果:1.先把索引之后的数据都拿出来先进性存储
                     2.在索引之后进行数据的覆盖
                     3.在进行原有数据的插入

                     老师的方法用一个数组进行数据存储，避免了写入写出的麻烦
     */
    @Test
    public void testInsert() throws IOException {
        //File fTemp = new File("temp.txt");
        File f = new File("xixi.txt");

        //RandomAccessFile rafWO = new RandomAccessFile(fTemp,"rw");
        RandomAccessFile rafW = new RandomAccessFile(f,"rw");
        //RandomAccessFile rafR = new RandomAccessFile(fTemp,"r");

        StringBuilder sb = new StringBuilder();
        long len = f.length() / 2;
        System.out.println(len);

        //1
        rafW.seek(len);
        byte buffer [] = new byte[10];
        int length;
        while((length=rafW.read(buffer))!=-1){
            //rafWO.write(buffer,0,length);
            sb.append(new String(buffer,0,length));
        }

        //2
        rafW.seek(len);//因为指针是变化的，所以这里需要把指针重新归位
        rafW.write("xyz".getBytes());
        rafW.write(sb.toString().getBytes());

/*      //3
        rafW.seek(len+"xyz".length());
        int readLen;
        byte buffer1 [] = new byte[10];
        while((readLen=rafR.read(buffer1))!=-1){
            rafW.write(buffer1,0,readLen);
        }*/




    }
}

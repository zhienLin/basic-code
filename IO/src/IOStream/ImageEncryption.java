package IOStream;
/*
实现图片加密操作。提示:
int b = 0;
while( (b = fis.read())!= -1){
fos.write(b ^ 5);
}
 */

import org.junit.Test;

import java.io.*;

public class ImageEncryption {

    @Test
    public void imageEncryption() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream("4.jpg");
            FileOutputStream fos = new FileOutputStream("4new.jpg");
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];

            int length;
            while((length=bis.read(buffer))!=-1){
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]= (byte) (buffer[i] ^ 5);
                }
                bos.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void imageDecryption() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream("4new.jpg");
            FileOutputStream fos = new FileOutputStream("3.jpg");
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];

            int length;
            while((length=bis.read(buffer))!=-1){
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]= (byte) (buffer[i] ^ 5);
                }
                bos.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}

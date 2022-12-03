import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Random;

/**
 * @author zzy
 * @date 2022-11-07 14:46
 */
public class XinShape {
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        for (float y = 2.5f; y > -2.0f; y -= 0.12f) {
            for (float x = -2.3f; x < 2.3f; x += 0.041f) {
                float a = x * x + y * y - 4f;
                if ((a * a * a - x * x * y * y * y) < -0.0f) {
                    String str = "Fighting!";
                    int num = count % str.length();
                    System.err.print(str.charAt(num));
                    count++;
                } else {
                    System.err.print(" ");
                }
            }
            System.err.println();
            Thread.sleep(100);
        }
    }


    @Test
    public void test(){
        String red;
        //绿色
        String green;
        //蓝色
        String blue;
        //生成随机对象
        Random random = new Random();
        //生成红色颜色代码
        red = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成绿色颜色代码
        green = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成蓝色颜色代码
        blue = Integer.toHexString(random.nextInt(256)).toUpperCase();

        //判断红色代码的位数
        red = red.length()==1 ? "0" + red : red ;
        //判断绿色代码的位数
        green = green.length()==1 ? "0" + green : green ;
        //判断蓝色代码的位数
        blue = blue.length()==1 ? "0" + blue : blue ;
        //生成十六进制颜色值
        String color = "#"+red+green+blue;

        System.out.println(color);
    }

}


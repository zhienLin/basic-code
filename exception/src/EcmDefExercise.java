import java.lang.reflect.Array;
import java.util.Scanner;

public class EcmDefExercise {
    //编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
    //对数据类型不一致(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException)
    //除O(ArithmeticException)及输入负数(EcDef自定义的异常)进行异常处理
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入非负整被除数:");
            String s1 = sc.nextLine();
            System.out.println("请输入非负整除数:");
            String s2 = sc.nextLine();
            int r1 = Integer.parseInt(s1);
            int r2 = Integer.parseInt(s2);
            int arr [] = {r1,r2};
            if(r1 < 0 || r2 < 0)
                throw new MyException("No!");
            else
                System.out.println(arr[0]/arr[1]);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        } catch (MyException e) {
            System.out.println("负数不可以哦");
        } catch (ArithmeticException e) {
            System.out.println("除数不能是0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界了吧");
        }

    }

}

class MyException extends RuntimeException{
    static final long serialVersionUID = -7134897190745766939L;
    public MyException(){}
    public MyException(String message){
        super(message);

    }

}


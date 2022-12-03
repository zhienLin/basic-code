import java.util.Date;
import java.util.Scanner;

public class exception1 {
/*    Exception:其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如:
                空指针访问
                试图读取不存在的文件
                网络连接中断
                数组角标越界*/
    //分为编译异常（受检异常）和运行异常（未受检异常）

    public static void main(String[] args) {
/*      1---Nu11PointerException
        2---ArrayIndexOutOfBoundsException
        3---ClassCastException
        4---NumberFormatException
        5---InputMismatchException
        6---ArithmeticException
*/
        //1---Nu11PointerException 空指针异常
        //int [] arr = null;
        //System.out.println(arr[1]);

        //2---IndexOutOfBoundsException 索引越界异常
        int [] arr = new int[9];
        //System.out.println(arr[9]);ArrayIndexOutOfBoundsException;
        String str = "123";
        //System.out.println(str.charAt(3));StringIndexOutOfBoundsException

        //3---ClassCastException 类型转换异常
            //Object ob = new Date(60);
            //String st = (String) ob;
            //class java.util.Date cannot be cast to class java.lang.String

        //4---NumberFormatException 数字格式异常
        String st = "abc";
        //Integer it = Integer.parseInt(st);

        //5---InputMismatchException 输入不匹配异常（主要是由于Scanner引入的）
/*        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(s);*/

        //6---ArithmeticException 算数异常
        int a = 9;
        int b = 3;
        System.out.println(a/b);


    }

}

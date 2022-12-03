package Test;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.print("请输入一个大于2的整数，以便于求解它的平方根:");
        int num = sr.nextInt();
/*        int i = 1;
        while(i * i <= num){
            i = i + 1;
        }
        int sqrt1 = i-1;
        System.out.println(sqrt1);*/

        for (int i = 1; i <= num; i++) {
            if (i * i == num) {
                System.out.println(i+"就是"+num+"的平方根");
                break;
            } else if(i * i > num) {
                System.out.println((i-1)+"就是"+num+"的平方根的整数部分");
                break;
            }
        }

    }
}

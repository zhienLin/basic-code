package www.itheima.demo;

import java.util.ArrayList;
import java.util.Scanner;
/*键盘录入1~100之间的整数，并添加到合集里面
直到集合中所有的数据和超过200*/

public class Exercise01 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList();//集合里面不能放置基本数据类型
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true) {
            System.out.print("录入一个1~100之间的整数:");
            String s = sc.nextLine();
            Integer i = Integer.parseInt(s);
            integers.add(i);
            sum = sum + i;
            if (sum > 200){
                integers.add(i);
                break;
            }
            else
                integers.add(i);
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i)+" ");
        }

    }
}

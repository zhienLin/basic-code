package StringPractice;

import java.util.Random;
import java.util.Scanner;

public class PracticeRandom {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.print("请输入一个任意的字符串：");
        String s1 = s.next();
        char[] chs = s1.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int a = r.nextInt(chs.length);
            char temp = chs[i];
            chs[i] = chs[a];
            chs[a] = temp;
        }
        String news = new String(chs);
        System.out.println(news);

    }
}

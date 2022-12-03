package www.itheima.com.Lambda;

import java.util.Arrays;

public class StringLengthSort {
    public static void main(String[] args) {
        String arrString [] ={"1234","1","12345678","123","123456","","123456789","12","12345","1234567"};

        Arrays.sort(arrString, (o1, o2) ->o1.length() - o2.length());

        System.out.println(Arrays.toString(arrString));




    }
}

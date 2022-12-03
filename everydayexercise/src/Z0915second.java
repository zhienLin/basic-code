import java.util.Arrays;

public class Z0915second {
    //给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
    public static void main(String[] args) {
        int num = 98368;
        System.out.println(maximumSwap(num));

    }
    //1.自己的方法
    public static int maximumSwap(int num) {
        String s = String.valueOf(num);
        StringBuilder s1 = new StringBuilder(s);
        System.out.println(s1);
        boolean flag = false;
        for (int i = 0; i < s.length()-1; i++) {
            char max = s1.charAt(i);
            int index = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (max <= s1.charAt(j) ) {
                    max = s1.charAt(j);
                    index = j;
                    if(max !=s1.charAt(i))
                    flag = true;
                }
            }

            if (flag == true) {
                char temp = s.charAt(index);
                s1.setCharAt(index, s.charAt(i));
                s1.setCharAt(i, temp);
                int result = 0;
                for (int i1 = 0; i1 < s1.length(); i1++) {
                    result = s1.charAt(i1) - '0' + result * 10;
                }
                return result;
            }
        }

        return num;
    }

    //2.别人的方法

    /*public static int maximumSwap1(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(charArray, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return maxNum;
    }

    public static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }*/




}
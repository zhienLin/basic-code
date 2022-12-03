import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 *
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 *
 * 返回 满足这个性质的 s 的任意排列 。
 * @author zzy
 * @date 2022-11-14 08:55
 */
public class Z1114 {
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        //String s3 = customSortString(order, s);
        //System.out.println(s3);
        String s2 = customSortString1(order, s);
        System.out.println(s2);
        char[] chars = s.toCharArray();
        int flag =0;
        for (int i = 0; i <order.length(); i++) {
            int index = -1;
            while((index=s.indexOf(order.charAt(i)))!=-1 && flag<chars.length){
                char temp;
                temp = chars[flag];
                chars[flag] = chars[index];
                chars[index] = temp;
                String s1 = new String(chars);
                String st = "";
                for (int i1 = 0; i1 <= flag; i1++) {
                    st = st + "*";
                }
                s = st+ s1.substring(++flag);

            }
        }
        System.out.println(new String(chars));


        int i = climbStairs(4);
        System.out.println(i);
    }

    public static String customSortString(String order, String s){
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i <order.length(); i++) {
            int index = -1;
            while ((index = sb1.indexOf(order.charAt(i) + "")) != -1) {
                sb2.append(order.charAt(i));
                sb1.deleteCharAt(index);
            }
        }
            return new String(sb2+""+sb1);
    }


    public static String customSortString1(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            val[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (c0, c1) -> val[c0 - 'a'] - val[c1 - 'a']);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

    public static int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public static int[][] pow(int[][] q, int n){
        int eye [][] = {{1,0},{0,1}};
        for (int i = 0; i < n; i++) {
            eye = multiply(eye,q);
        }
        return eye;
    }

    private static int[][] multiply(int[][] eye, int[][] q) {
        int arr [][] = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j]= eye[i][0] * q[0][j] + eye[i][1] *q[1][j];
            }
        }
        return arr;
    }


    public static int climbStairs2(int n) {
        int p = 0,q =0;
        int r =1;
        for (int i = 1; i <= n; i++) {
            p=q;
            q=r;
            r = p + q;
        }
        return  r;
    }


}

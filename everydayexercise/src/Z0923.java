import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Z0923 {
/*  对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。

    给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
    ab ba    abcfad     bfadca  1afbdca  2 abfdca 3 abcdfa 4 abcfda 5 abcfad
    固定一个字符串不变，先拿到固定字符串的第一个索引去比较，找到相同的值,
    把非固定的字符串进行交换,再去找第二个索引,找到相同的值,进行交换。。。。

    */
    public static void main(String[] args) {
        String s1 = "hjkfgkl";
        String s2 = "jkhgflk";
        int i = kSimilarity(s1, s2);
        System.out.println(i);

    }
    public static int kSimilarity(String s1, String s2) {
        int num = 0;
        /*//检查一次的
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)){
                s1= new StringBuffer(s1).deleteCharAt(i).toString();
                s2= new StringBuffer(s2).deleteCharAt(i).toString();
            }
        }
        //检查两次的
        for (int i = 0; i < s1.length();i++) {
            int j = s2.indexOf(s1.charAt(i));
            if(s1.charAt(i) == s2.charAt(j)&& s1.charAt(j) == s2.charAt(i)){
                s1 = new StringBuffer(s1).deleteCharAt(i).toString();
                s1 = new StringBuffer(s1).deleteCharAt(--j).toString();
                s2 = new StringBuffer(s2).deleteCharAt(i).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j).toString();
                num++;
                i=-1;
            }

        }
        //检查三次的
        for (int i = 0; i < s1.length();i++) {
            //满足条件的三个元素的索引值
            int j1 = s2.indexOf(s1.charAt(i));
            int j2 = s2.indexOf(s1.charAt(j1));
            int j3 = s2.indexOf(s1.charAt(j2));
            //对索引值进行排序
            if(j3 == i){
                int [] arr = {j1,j2,j3};
                Arrays.sort(arr);
                s1 = new StringBuffer(s1).deleteCharAt(j1).toString();
                s1 = new StringBuffer(s1).deleteCharAt(j2).toString();
                s1 = new StringBuffer(s1).deleteCharAt(j3).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j1).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j2).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j3).toString();
                num += 2;
                i=-1;
            }
        }
        //检查四次的
        for (int i = 0; i < s1.length();i++) {
            //满足条件的三个元素的索引值
            int j1 = s2.indexOf(s1.charAt(i));
            int j2 = s2.indexOf(s1.charAt(j1));
            int j3 = s2.indexOf(s1.charAt(j2));
            int j4 = s2.indexOf(s1.charAt(j3));
            //对索引值进行排序
            if(j4 == i){
                int [] arr = {j1,j2,j3,j4};
                Arrays.sort(arr);
                s1 = new StringBuffer(s1).deleteCharAt(j1).toString();
                s1 = new StringBuffer(s1).deleteCharAt(j2).toString();
                s1 = new StringBuffer(s1).deleteCharAt(j3).toString();
                s1 = new StringBuffer(s1).deleteCharAt(j4).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j1).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j2).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j3).toString();
                s2 = new StringBuffer(s2).deleteCharAt(j4).toString();
                num += 3;
                i=-1;
            }
        }*/

        num = checkGroup(s1, s2, 2);


        return num;

    }


    //检查N次
    public static int checkGroup(String s1, String s2, int N){
        int num = 0;
        if(N == 1){
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) == s2.charAt(i)){
                    s1= new StringBuffer(s1).deleteCharAt(i).toString();
                    s2= new StringBuffer(s2).deleteCharAt(i).toString();
                    i--;
                    num++;
                }
            }
        }
        else{
            for (int i = 0; i < s1.length(); i++) {
                int temp = i;
                Integer[] arr = new Integer[N];
                for (int j = 0; j < N; j++) {
                    temp = s2.indexOf(s1.charAt(temp));
                    arr[j] = temp;
                }
                //对索引值进行排序
                Arrays.sort(arr, (o1, o2) -> o2 - o1);
                if (temp == i) {
                    for (int j = 0; j < N; j++) {
                        s1 = new StringBuffer(s1).deleteCharAt(arr[j]).toString();
                        s2 = new StringBuffer(s2).deleteCharAt(arr[j]).toString();
                    }
                    num += N - 1;
                    i = -1;
                }
            }
        }
        return num;

    }


}

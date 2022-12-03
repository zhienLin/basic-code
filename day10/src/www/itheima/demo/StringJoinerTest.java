package www.itheima.demo;

import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i]+"");
            //add里面只能添加字符串，不能添加整数,所以后面又接了一个字符串的空格形式
        }
    }
}
//注意：在使用StringJoiner进行字符串的拼接的时候，由于add()函数只能对字符串进行拼接，所以后面一般可以加一个空的字符串。
//这跟StringBuilder不一样，StringBuilder可以直接用appden(),里面的形式可以是任意的，这里需要注意一下。
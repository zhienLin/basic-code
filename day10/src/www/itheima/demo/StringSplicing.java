package www.itheima.demo;

public class StringSplicing {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        String news = splicing(arr);
        for (int i = 0; i < news.length(); i++) {
            System.out.print(news.charAt(i));
        }

    }

    public static String splicing(int[] arr) {
        String s = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            s = s + arr[i] + ", ";
        }
        s = s + arr[arr.length - 1] + "]";
        return s;
    }
}
//需要注意的是：我们在进行数字和字符串想加的时候，会自动把数字的值变成字符串的形式和字符串在此拼接，因为不需要再把数字转换成什么别的类型啦。
//你在这里犯的一个错误就是不知道怎么处理数字转换成字符串的问题，还用到了(char)类型的强制转化，这根本不需要的好吧！！
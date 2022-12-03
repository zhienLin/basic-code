package www.itheima.demo;

public class InverseString {
    public static void main(String[] args) {
        String s = "abcdef";

        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        String inverse = inverse(s);
        for (int i = 0; i < inverse.length(); i++) {
            System.out.print(inverse.charAt(i));
        }
    }

    public static String inverse(String s){
        String s1 = new String();
        if(s == null){
            return "";
        }
        if(s.length() == 0)
            return "";

        for (int i = s.length()-1; i >= 0; i--) {
            s1 =s1 +s.charAt(i);
        }
        return s1;
    }
}

//每天都学一个小技巧，我们都知道:字符串名.length().fori 是i从 0 开始到 字符串名.length()-1 结束。
//但是如果我们想要去倒着遍历的时候，就要去用：字符串名.length().forr,这样就可以了。
//Shift + F6 批量替换，就是选中某一个变量名，这个我没有操作成功呢！

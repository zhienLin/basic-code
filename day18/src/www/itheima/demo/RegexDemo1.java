package www.itheima.demo;

public class RegexDemo1 {
    public static void main(String[] args) {
        //在正则表达式中，如果只写一个且，那就只是一个简单的且符号而已
        //只有两个&&才是且符号
        System.out.println("&".matches("[a-z&[b-f]]"));//true
        System.out.println("&".matches("[a-z&&[b-f]]"));//false
        System.out.println("b".matches("[a-z&&[^b-f]]"));//false
        System.out.println("ab".matches("[a-z][a-z]"));//true

        // \是一个转义字符，代表转换后面的意思。
        System.out.print("xixi");
        System.out.print("\\");
        System.out.print("haha");

        System.out.println("ab".matches(".."));//true
        System.out.println("a".matches(".."));//false

        // \\才代表\，所以\\d就是 \d
        System.out.println("a".matches("\\d"));//false
        System.out.println("9".matches("\\d"));//false

        //  \\w是数字、字母、下划线
        System.out.println("_".matches("\\w"));//false


    }
}

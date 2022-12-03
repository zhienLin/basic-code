package www.itheima.demo;
public class RegexDemo11 {
    public static void main(String[] args) {
        String s = "哈哈bxcsdhb嘻嘻adjshxbjas黑暗圣经";

        //1.替换
        String regex1 = "[\\w^_]+";
        //方法在底层跟之前一样，也会去创建文本解析器的对象 Matcher
        //然后从头去读取字符串中的内容，只要满足，就会发生替换。
        String replaces = s.replaceAll(regex1,"vs");
        System.out.println(replaces);
        //字符串本身是不能替换的，只有返回值才是替换之后的
        System.out.println(s);//哈哈bxcsdhb嘻嘻adjshxbjas黑暗圣经


        //2.切割
        String regex2 = "[\\w^_]+";
        String[] split = s.split(regex2);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }



    }

}

package www.itheima.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindBugUpgrade1 {
    public static void main(String[] args) {
/*      需求1:爬取版本号为8,11,17的Java文本，但是只要]ava，个显示版本号。
        需求2:爬取版本号为8,11,17的Java文本。正确爬取结果为: Java8 Java11 Java17 Java17
        需求3:爬取除了版本号为8,11,17的Java文本，*/
        String s = "java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和JAva11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是JAVa17，相信在未来不久JAVA17也会逐渐登上历史舞台";
        //1.定义正则表达式
        //?理解为前面的数据Java
        //=表示在Java后面要跟随的数据,但是在获取的时候，只获取前半部分.
        //需求1
        String regex1 = "((?i)Java)(?=8|11|17)";
        //需求2:
        //:表示在Java后面要跟随的数据,在获取的时候，一起获取。
        //加冒号跟不加冒号没什么两样
        String regex2 = "((?i)Java)(8|11|17)";
        String regex3 = "((?i)Java)(?:8|11|17)";
        //需求3:
        //！表示在Java后面要跟随的数据,在获取的时候，不要后面有这个数据的值。
        String regex4 = "((?i)Java)(?!8|11|17)";
        Pattern p = Pattern.compile(regex3);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
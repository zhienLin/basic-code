package www.itheima.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindBugUpgrade2 {
    public static void main(String[] args) {
/*      需求1:按照ab+的方式爬取ab,b尽可能地多获取。
        需求2:按照ab+的方式爬取ab,b尽可能地少获取。*/
        //贪婪爬取：尽可能多获取（默认的就是这） + / *
        //非贪婪爬取：尽可能少获取 +？/ *?



        String s = "java自从95年问世以来，abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaa经历了很多版本，目前企业中用的最多的是Java8和JAva11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是JAVa17，相信在未来不久JAVA17也会逐渐登上历史舞台";
        //定义正则表达式
        //需求1
        String regex1 = "ab+?";
        //需求2:
        String regex2 = "ab*?";
        Pattern p = Pattern.compile(regex2);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
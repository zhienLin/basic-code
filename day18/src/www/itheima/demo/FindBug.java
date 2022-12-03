package www.itheima.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindBug {
/*  练习
    本地爬虫和网络爬虫
    需求:把下面文本中的电话，邮箱，手机号，热线都爬取出来。
    来黑马程序员学习Java,
    电话:18512516758，1851250890R
    或者联系邮箱: boniu@itcast.cn,
    座机电话:01036517895,010-98951256
    邮箱: bozai@itcast.cn,
    热线电话:400-618-9090，400-618-4000，4006184000，4006189090
    */

    public static void main(String[] args) {
        String str = "来黑马程序员学习Java," +
                "电话:18512516758，1851250890R" +
                "或者联系邮箱: boniu@itcast.cn," +
                "座机电话:01036517895,010-98951256" +
                "邮箱: bozai@itcast.cn," +
                "热线电话:400-618-9090，400-618-4000，4006184000，4006189090";
        String regexPhone = "1[3-9]\\d{9}";
        String regexTablePhone = "0\\d{2,3}-?[1-9]\\d{4,9}";
        String regexEmail = "\\w+@[\\w&&[^_]]{2,6}(.[a-zA-Z]{2,3}){1,2}";
        String hotline = "([0-9]\\d{2}-?){2}[0-9]\\d{3}";
        //获取正则表达式对象
        Pattern p = Pattern.compile("(1[3-9]\\d{9})|(0\\d{2,3}-?[1-9]\\d{4,9})|" +
                "(\\w+@[\\w&&[^_]]{2,6}(.[a-zA-Z]{2,3}){1,2})|(([0-9]\\d{2}-?){2}[0-9]\\d{3})");
        //获取文本匹配器的对象
        Matcher m = p.matcher(str);
        while(m.find()){
            String group = m.group();
            System.out.println(group);
        }
    }

}

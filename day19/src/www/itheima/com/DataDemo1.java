package www.itheima.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataDemo1 {
    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
/*      默认格式
        指定格式
        格式化（日期对象-字符串）
        解析:parse()（字符串-日期对象）*/



        SimpleDateFormat sdf1 = new SimpleDateFormat();//空参是默认的格式
        Date d1 = new Date();
        String format1 = sdf1.format(d1);
        System.out.println(format1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//带参构造指定格式
        String format2 = sdf2.format(d1);
        System.out.println(format2);

        //课堂练习：yyyy年MM月dd日 HH:mm:ss 星期
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EE");
        String format3 = sdf3.format(d1);
        System.out.println(format3);

//=================================================================================================================
        //下面的这部分主要就是把我们定义的字符串再一次解析出来，方便对其进行时间上的操作
        String str = "2022年08月07日 19:54:56";
        //创建对象的格式要跟字符串的格式完全一致
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date parse = sdf.parse(str);
        System.out.println(parse);

//==================================================================================================================
        String data = "2000-11-11";
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = sdf4.parse(data);
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy年MM月dd日");
        String format = sdf5.format(parse1);
        System.out.println(format);
    }
}

package www.itheima.demo;

/*
用代码计算你活了多少天
分别用JDK7和JDK8进行计算
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Exercise04 {
    public static void main(String[] args) throws ParseException {
        String c = "1999-8-13";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sd.parse(c);
        System.out.println(daysJDK7(parse));
        LocalDateTime zdBirth = LocalDateTime.of(1998, 11, 8,10,56);
        long l = daysJDK8(zdBirth);
        System.out.println("亲爱的朋友：");
        System.out.println("你已经活了"+daysJDK7(parse)+"天.");
    }

    //JDK7
    public static long daysJDK7(Date cBirth) {
        Date now = new Date();
        long l = (now.getTime() - cBirth.getTime()) / (24 * 60 * 60 * 1000);
        return l;
    }

    //JDK8
    public static long daysJDK8(LocalDateTime zdBirth) {
        LocalDateTime zdNow = LocalDateTime.now();
        Duration between1 = Duration.between(zdBirth, zdNow);
        long between = ChronoUnit.DAYS.between(zdBirth, zdNow);
        return between;
    }
}

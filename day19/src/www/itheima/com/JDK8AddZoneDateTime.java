package www.itheima.com;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JDK8AddZoneDateTime {
    public static void main(String[] args) {


//1.获取当前时间对象(带时区)
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
//2.获取指定的时间对象(带时区)
//年月日时分秒纳秒方式指定
        ZonedDateTime time1 = ZonedDateTime.of(2022,11,8,10,53,46,4342,ZoneId.of( "Asia/Shanghai"));
        System.out.println(time1);
//通过Instant +时区的方式指定获取时间对象
        Instant instant = Instant.ofEpochMilli(0L);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime time2 = ZonedDateTime. ofInstant(instant, zoneId);
        System.out.println(time2);

//ZonedDateTime withXxx(时间) 修改时间系列的方法
        ZonedDateTime zonedDateTime = time1.withYear(2021);
        System.out.println(zonedDateTime);

//ZonedDateTime minusXxx(时间)减少时间系列的方法
        ZonedDateTime zonedDateTime1 = time2.minusDays(1);
        System.out.println(zonedDateTime1);


    }
}
/*
summarization:
这个是获取带有时区的时间，感觉是把前面两个类Instant和ZoneId结合起来了。
1、static ZonedDateTime now() 获取当前时间的ZonedDateTime对象
2、static ZonedDateTime ofXxxx() 获取指定时间的ZonedDateTime对象
3、ZonedDateTime withXxx(时间) 修改时间系列的方法
4、ZonedDateTime minusXxx(时间)减少时间系列的方法
5、ZonedDateTime p1usXxx(时间)增加时间系列的方法
PS:JDK8对时间进行操作的本身的值是不会发生改变的，而是产生一个新的对象。

其实我们前三个新增的类都类似于在Date上进行了扩展
*/
package www.itheima.com;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JDK8AddInstant {
    public static void main(String[] args) {
        //一、获取当前时间的Instat对象
        Instant now = Instant.now();//我们的时区是在此基础上加8
        System.out.println(now);

        //二、指定时间
        //1.毫秒值
        Instant instant1 = Instant.ofEpochMilli(0L);
        System.out.println(instant1);

        //2.秒
        Instant instant2 = Instant.ofEpochSecond(1L);
        System.out.println(instant2);

        //3.在秒的基础上加纳秒
        Instant instant3 = Instant.ofEpochSecond(1L, 1000000L);
        System.out.println(instant3);

        //三、指定时区
        //atZone()这个方法不是一个静态方法，所以不能用类名直接调用,必须先去创建一个Instant的对象；
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Canada/Atlantic"));
        System.out.println(zonedDateTime);

        //四、is***用来比较时间值的前后
        Instant instant4 = Instant.ofEpochMilli(1000L);
        Instant instant5 = Instant.ofEpochMilli(999L);
        //调用者的时间值是否在后面对象的时间值的前面
        boolean after = instant4.isAfter(instant5);
        System.out.println(after);
        //调用者的时间值是否在后面对象的时间值的后面
        boolean before = instant4.isBefore(instant5);
        System.out.println(before);

        //五、减少时间的方法
        Instant instant6 = Instant.ofEpochSecond(60L);
        Instant instantMinus = instant6.minusSeconds(1);
        System.out.println(instantMinus);

        //六、增加时间的方法
        Instant instant7 = Instant.ofEpochSecond(60L);
        Instant instantPlus = instant6.plusSeconds(5);
        System.out.println(instantPlus);


    }
}


/*
summarization:
1、Instant.now() 获取当前时间的Instant对象，我们的时区是在此基础上加8。
2、Instant.ofEpochMilli()/Instant.ofEpochSecond()/Instant.ofEpochSecond(1L, 1000000L)，
   用来指定时间，是在原点的基础上加具体的值。
3、指定时区：atZone()。这个方法不是一个静态方法，所以不能用类名直接调用,必须先去创建一个Instant的对象。
4、isAfter()/isBefore() 比较两个时间的先后关系
5、minusSeconds()/plusSeconds() 减少/增加时间的方法


对比：之前我们在考虑Data对象的时候，如果要去比较两个对象的时间，
     必须先用函数获取当前的时间值，然后再去调用Math函数的。但是新增的可以直接调用静态方法进行比较。
*/
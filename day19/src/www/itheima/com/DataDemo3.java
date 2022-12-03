package www.itheima.com;


import java.util.Date;

//JDK之前的
public class DataDemo3 {
    public static void main(String[] args) {
        //创建对象表示时间
        Date a = new Date();
        System.out.println(a);

        //创建对象指定时间
        Date b = new Date(1000L);
        System.out.println(b);

        //修改时间
        //1000毫秒是时间的毫秒值
        b.setTime(2000L);
        System.out.println(b);

        //获得时间
        long time = b.getTime();
        System.out.println(time);

        //1.打印时间原点1年之后的时间
        Date oneyear = new Date(365*24*60*60*1000L);
        System.out.println(oneyear);

        //2.定义两个Data对象，比较一下哪个时间在前
        Date comyear1 = new Date((long) (Math.random()*1000000000));
        Date comyear2 = new Date((long) (Math.random()*1000000000));
        System.out.println(comyear1);
        System.out.println(comyear2);
        System.out.println(Math.max(comyear1.getTime(),comyear2.getTime()));

    }
}

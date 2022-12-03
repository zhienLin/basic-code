package www.itheima.com;

import java.util.Calendar;
import java.util.Date;

public class Calendar01 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);

        Date d1 = new Date(10000000000L);
        instance.setTime(d1);
        System.out.println(instance);
        Date time = instance.getTime();
        System.out.println(time);

        //get(filed)这个方法可以调取的一共有16个索引值，
        //你可以通过选择跟进来查看每一个索引值对应的属性
        //并且可以拼写选择，也很方便。
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);//月份记得要加1
        int data = instance.get(Calendar.DAY_OF_MONTH);
        int week = instance.get(Calendar.DAY_OF_WEEK);

        System.out.println(year + "," + (month+1) + "," + data + "," + week);

        //具体该怎么去设定的方法
        instance.set(Calendar.YEAR,2000);
        System.out.println(instance.get(Calendar.YEAR));

        //可以任意的加或者是减某个字段的值
        instance.add(Calendar.MONTH,-2);//正数是增加，负数就是减少往前调。
        int year1 = instance.get(Calendar.YEAR);
        int month1 = instance.get(Calendar.MONTH);//月份记得要加1
        int data1 = instance.get(Calendar.DAY_OF_MONTH);
        int week1 = instance.get(Calendar.DAY_OF_WEEK);
        System.out.println(year1 + "," + (month1+1) + "," + data1 + "," + week1);
    }

}


/*
summarization:
作用：虽然我们之前能够把Date类型的数据通过调用SimpleDateFormat()，转化成我们想要的格式，
     但是我们没有办法直接对他的年、月、日进行操作，因此引出了Calender类。
1、因为Calender是一个抽象类，并不能直接闯进对象，而是通过调用函数来获取他的子类对象"getInstance()",
   默认是当前时间，根据系统不同地时区来获取不同的日历对象，会把中间地每一份信息
   （年、月、日等）返回成为一个数组的形式
   PS：月份是0~11 星期日是第一天。
2、get(filed)这个方法可以调取的一共有16个索引值，可以通过选择跟进来查看每一个索引值对应的属性
   意思对应，英文书写也很方便。
3、set(Calendar.YEAR,2000);直接设定他们的具体信息
4、instance.add(Calendar.MONTH,-2);可以任意的加或者是减某个字段的值，正数是加，负数代表的是减。
*/
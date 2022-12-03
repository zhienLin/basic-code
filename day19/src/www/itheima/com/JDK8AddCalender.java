package www.itheima.com;

import java.time.*;

public class JDK8AddCalender {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);
        LocalDate ofDate = LocalDate.of(2021, 12, 1);
        int year = ofDate.getYear();//获取年
        Month month = ofDate.getMonth();//获取月，但是输出的是Month类型的值
        int value = month.getValue();//这个方法也能得到
        int intMonth = ofDate.getMonthValue();//获取月，输出的是整数,
        System.out.println(year);
        System.out.println(month);
        System.out.println(intMonth);
        //is是比较时间的前后
        LocalDate localDate1 =LocalDate.of(2022,6,9);
        LocalDate localDate2 =LocalDate.of(2022,6,10);
        boolean s = localDate1.isAfter(localDate2);
        System.out.println(s);
        //with是修改时间
        LocalDate localDateWith =localDate1.withMonth(7);
        System.out.println(localDateWith);

        //minus 和 plus 的方法
        localDate1.minusMonths(1L);


        LocalDate birth = LocalDate.of(1998, 11, 8);
        LocalDate ofBirth = LocalDate.now();


        //还有一个月日的对象，这个对象里面不包含年
        MonthDay birthDay = MonthDay.of(birth.getMonth(),birth.getDayOfMonth());
        MonthDay from = MonthDay.from(ofBirth);//这个from的作用主要是要把年份去掉，留下月份。
        System.out.println("=================================================");
        System.out.println(from.equals(birthDay));


        //对时间的精确度要求比较高的时候：LocalTime
        //完整类：LocalDateTime






















    }
}
//1、1就是1月，不需要去对应索引值。
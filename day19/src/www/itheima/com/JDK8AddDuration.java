package www.itheima.com;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

//主要用于计算时间间隔的工具类，年月日/时分秒/
public class JDK8AddDuration {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate ofBirthday = LocalDate.of(1998, 11, 8);

        //是第二个参数减去第一个参数
        Period between = Period.between(ofBirthday,now);

        int years = between.getYears();
        int months = between.getMonths();
        int days = between.getDays();

        System.out.println(years+","+months+","+days);

System.out.println("===================================");

        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime ofBirth = LocalDateTime.of(1998, 11, 8, 10, 56, 06);
        Duration between1 = Duration.between(ofBirth, now1);
        System.out.println(between1);
        System.out.println(between1.toDays());
        System.out.println(between1.toHours());
        System.out.println(between1.toMinutes());
        System.out.println(between1.toSeconds());


System.out.println("===================================");
        LocalDateTime birthDate=LocalDateTime.of(1998, 11, 8, 10, 56, 06);
        LocalDateTime today = LocalDateTime.now();
        System.out.println("相差的年数:" + ChronoUnit.YEARS.between(birthDate, today));
        System.out.println("相差的月数:" + ChronoUnit.MONTHS.between(birthDate, today));
        System.out.println("相差的周数:"+ ChronoUnit.WEEKS.between(birthDate, today));
        System.out.println("相差的天数:"+ ChronoUnit.DAYS.between(birthDate, today));
        System.out.println("相差的时数:" + ChronoUnit.HOURS.between(birthDate, today));
        System.out.println("相差的分数:"+ ChronoUnit.MINUTES.between(birthDate, today));
        System.out.println( "相差的秒数:"+ ChronoUnit.SECONDS.between(birthDate, today));
        System.out.println("相差的毫秒数:"+ ChronoUnit.MILLIS.between(birthDate, today));
        System.out.println("相差的微秒数:"+ ChronoUnit.MICROS.between(birthDate, today));
        System.out.println("相差的纳秒数:"+ ChronoUnit.NANOS.between(birthDate, today));
        System.out.println("相差的半天数:"+ ChronoUnit.HALF_DAYS.between(birthDate, today));
        System.out.println("相差的十年数:"+ ChronoUnit.DECADES.between(birthDate, today));
        System.out.println("相差的世纪(百年)数:"+ ChronoUnit.CENTURIES.between(birthDate, today));
        System.out.println("相差的千年数:"+ ChronoUnit.MILLENNIA.between(birthDate, today));
        System.out.println("相差的纪元数:"+ ChronoUnit.ERAS.between(birthDate, today));


    }
}
//Period 关注点是 年月日
//Duration 关注点是 时分秒
//ChronoUnit  这是最常用的，也是功能最强大的/
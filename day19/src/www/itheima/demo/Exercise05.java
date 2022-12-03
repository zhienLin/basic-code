package www.itheima.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//判断一年是平年还是闰年（7、8）两种方法
//好像没有实际的意义
public class Exercise05 {
    public static void main(String[] args) throws ParseException {

        //jdk7
        String date = "2009-12-3";
        System.out.println(JDK7Verifyate(date));

        //jdk8 isLeapYear()


    }

    //jdk7
    private static String  JDK7Verifyate(String date) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = sd.parse(date);
        String result;
        Calendar instance = Calendar.getInstance();
        instance.setTime(parseDate);
        int year = instance.get(Calendar.YEAR);
        if(year%4==0)
            result = "闰年";
        else
            result = "平年";

        return result;
    }

    //jdk8





}

package www.itheima.com;

import java.time.ZoneId;
import java.util.Set;

public class JDK8AddZoneId {
    //JDK8这部分就是主要的进行了一些简化
    //主要从代码层面和安全层面(涉及到了多线程的问题)进行了简化
    //新增了10种新的类，我们可以归纳为4个方面上去。

    //1.Zoneld时区 主要的定义形式为：洲名/城市名 或者 国家名/城市名 但是没有定义北京

    public static void main(String[] args) {
        //1.Zoneld时区 主要的定义形式为：洲名/城市名 或者 国家名/城市名 但是没有定义北京


        //1.1获取所有时区的名称 可以直接用英文翻译过来 get available zoneid
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds.size());
        System.out.println(availableZoneIds);

        //1.2 获取当前系统的默认时区 那就是Default呀
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        //1.3 获取指定的时区
        ZoneId of = ZoneId.of("Canada/Atlantic");
        System.out.println(of);


    }
 }
/*
summarization:
1、主要的定义形式为：洲名/城市名 或者 国家名/城市名 但是没有定义北京
2、获取所有时区的名称 可以直接用英文翻译过来 getAvailableZoneIds();
3、获取指定的时区  ZoneId.of("Canada/Atlantic");
*/
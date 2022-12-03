package www.itheima.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataDemo2 {
    public static void main(String[] args) throws ParseException {
        String startStr = "2023年11月11日 00:00:00";
        String finishtStr = "2023年11月11日 00:10:00";
        String jiaStr = "2023年11月11日 00:01:00";
        String pitStr = "2023年11月11日 00:11:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        Date parseStart = sdf.parse(startStr);
        Date parseFinish = sdf.parse(finishtStr);
        Date parseJia = sdf.parse(jiaStr);
        Date parsePi = sdf.parse(pitStr);

        long timeStart = parseStart.getTime();
        long timeFinish = parseFinish.getTime();
        long timeJia = parseJia.getTime();
        long timePi = parsePi.getTime();

        if(timeStart >= timeJia || timeFinish <= timeJia)
            System.out.println("小贾没有赶上领消费券");
        else
            System.out.println("小贾赶上了领消费券");

        if(timeStart >= timePi || timeFinish <= timePi)
            System.out.println("小皮没有赶上领消费券");
        else
            System.out.println("小皮赶上了领消费券");

    }
}

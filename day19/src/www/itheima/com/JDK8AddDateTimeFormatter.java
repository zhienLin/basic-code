package www.itheima.com;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JDK8AddDateTimeFormatter {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Canada/Atlantic"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        String format = dateTimeFormatter.format(zonedDateTime);
        System.out.println(format);
    }
}

//和之前的SimpleDateFormat一样
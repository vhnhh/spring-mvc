package ra.demo_spring_mvc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateTime {
    public static String dateTimeFormatter(Date date) {
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy/MM/dd - HH:mm");
        String formattedDateTime = pattern.format(date);
        return formattedDateTime;
    }
}

package org.lxp.dailylog.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtil {
    private static final ZoneId DEFAULT_ZONEID = ZoneId.of("Asia/Shanghai");

    public static Date now() {
        return localDateToDate(LocalDate.now());
    }

    public static String zonedDateTimeToString(ZonedDateTime zonedDateTime) {
        return ZonedDateTime.ofInstant(zonedDateTime.toInstant(), DEFAULT_ZONEID).toString();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(ZonedDateTime.of(localDateTime, DEFAULT_ZONEID).toInstant());
    }

    public static Date localDateToDate(LocalDate localDate) {
        ZonedDateTime zdt = localDate.atStartOfDay(DEFAULT_ZONEID);
        return Date.from(zdt.toInstant());
    }
}

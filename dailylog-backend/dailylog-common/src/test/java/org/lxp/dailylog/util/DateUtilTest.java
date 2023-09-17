package org.lxp.dailylog.util;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DateUtilTest {
    @Test
    public void testNow() {
        assertNotNull(DateUtil.now());
    }

    @Test
    public void testZonedDateTimeToString() {
        LocalDateTime localDate = LocalDateTime.of(2018, 5, 10, 0, 0, 10);
        assertEquals("2018-05-10T00:00:10+08:00[Asia/Shanghai]",
                DateUtil.zonedDateTimeToString(ZonedDateTime.of(localDate, ZoneId.of("Asia/Shanghai"))));
    }

    @Test
    public void testLocalDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 6, 24, 0, 0, 1, 1);
        assertEquals(1529769601000L, DateUtil.localDateTimeToDate(localDateTime).getTime());
    }

    @Test
    public void testLocalDateToDate() {
        LocalDate localDate = LocalDate.of(2018, 6, 24);
        assertEquals(1529769600000L, DateUtil.localDateToDate(localDate).getTime());
    }
}

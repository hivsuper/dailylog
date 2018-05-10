package org.lxp.dailylog.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
    @Test
    public void testNow() {
        Assert.assertNotNull(DateUtil.now());
    }

    @Test
    public void testFormat() throws Exception {
        LocalDateTime localDate = LocalDateTime.of(2018, 05, 10, 0, 0, 10);
        Assert.assertEquals("2018-05-10T13:00:10+08:00[Asia/Shanghai]",
                DateUtil.format(ZonedDateTime.of(localDate, ZoneId.systemDefault())));
    }

}

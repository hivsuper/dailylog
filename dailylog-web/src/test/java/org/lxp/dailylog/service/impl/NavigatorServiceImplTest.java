package org.lxp.dailylog.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.config.MemoryDBTest;
import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.service.NavigatorService;
import org.lxp.dailylog.web.util.JsonHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@MemoryDBTest
public class NavigatorServiceImplTest {
    @Resource
    private NavigatorService navigatorService;

    @Test
    public void testAddNavigator() {
        NavigatorBase navigator = new NavigatorBase();
        navigator.setName("333");
        navigator.setTitle("3333");
        navigator.setUrl("http://33.com");
        LocalDateTime localDateTime = LocalDateTime.of(2018, 6, 24, 0, 0, 0);
        navigator.setCreateTime(Date.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant()));
        navigator = navigatorService.addNavigator(navigator);
        assertTrue(JsonHelper.toString(navigator)
                .startsWith("{\"id\":2,\"name\":\"333\",\"url\":\"http://33.com\",\"title\":\"3333\""));
    }

    @Test
    public void testQueryNavigatorPage() {
        NavigatorBase navigator = navigatorService.queryNavigatorPage("222", 0, 10).getObjs().get(0);
        navigator.setCreateTime(null);
        assertEquals("{\"id\":1,\"name\":\"222\",\"url\":\"http://22.com\",\"title\":\"2222\"}",
                JsonHelper.toString(navigator));
    }
}
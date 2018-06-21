package org.lxp.dailylog.service.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.config.MemoryDBTest;
import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.service.NavigatorService;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        navigator.setCreatetime(DateUtil.now());
        navigator = navigatorService.addNavigator(navigator);
        navigator.setCreatetime(null);
        assertEquals("NavigatorBase [seqid=2, name=333, url=http://33.com, title=3333, createtime=null]",
                navigator.toString());
    }

    @Test
    public void testQueryOneByLike() {
        NavigatorBase navigator = navigatorService.queryOneByLike("222");
        assertEquals(
                "NavigatorBase [seqid=1, name=222, url=http://22.com, title=2222, createtime=Wed May 30 00:00:00 CDT 2018]",
                navigator.toString());
    }
}
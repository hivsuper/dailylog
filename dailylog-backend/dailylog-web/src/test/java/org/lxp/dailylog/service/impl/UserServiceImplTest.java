package org.lxp.dailylog.service.impl;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.config.MemoryDBTest;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.lxp.dailylog.util.CiphertextUtil.encode;

@RunWith(SpringJUnit4ClassRunner.class)
@MemoryDBTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void testAdd() {
        UserBase user = new UserBase();
        user.setUsername("super@2.com");
        user.setPassword(encode("727dfbdc1a4ee249f3f08c247a5669d5"));
        user.setLastLoginTime(DateUtil.now());
        user = userService.add(user);
        assertTrue(user.getId() > 0);
    }

    @Test
    public void testQueryOneUserByUsername() {
        UserBase user = userService.queryOneUserByUsername("super@1.com");
        assertThat(user.getId(), Matchers.is(1L));
    }

}

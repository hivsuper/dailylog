package org.lxp.dailylog.service.impl;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.config.MemoryDBTest;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.service.AccountService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@MemoryDBTest
public class AccountServiceImplTest {
    @Resource
    private AccountService accountService;

    @Test
    public void testAddAccount() {
        AccountBase account = accountService.addAccount("33", "33@33.com", "333@33.com", "33333", "aaaa",
                "http://33.com", LocalDate.now());
        assertTrue(account.getId() > 0);
    }

    @Test
    public void testQueryAccountPage() {
        AccountBase account = accountService.queryAccountPage("11", 0, 10).getObjs().get(0);
        assertThat(account.getId(), Matchers.is(1L));
    }

}

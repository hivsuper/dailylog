package org.lxp.dailylog.service.impl;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.config.MemoryDBTest;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@MemoryDBTest
public class AccountServiceImplTest {
    @Resource
    private AccountService accountService;

    @Test
    public void testAddAccountAccountBaseBoolean() {
        AccountBase account = new AccountBase();
        account.setUsername("22");
        account.setRemail("22@22.com");
        account.setFpemail("222@22.com");
        account.setPhone("22222");
        account.setProductname("aaaa");
        account.setProducturl("http://22.com");
        account.setJoindate(DateUtil.now());
        account.setCreatetime(DateUtil.now());
        account = accountService.addAccount(account, false);
        assertTrue(account.getSeqid() > 0);
    }

    @Test
    public void testAddAccount() {
        AccountBase account = accountService.addAccount("33", "33@33.com", "333@33.com", "33333", "aaaa",
                "http://33.com");
        assertTrue(account.getSeqid() > 0);
    }

    @Test
    public void testQueryOneLike() {
        AccountBase account = accountService.queryOneLike("11");
        assertThat(account.getSeqid(), Matchers.is(1L));
    }

}

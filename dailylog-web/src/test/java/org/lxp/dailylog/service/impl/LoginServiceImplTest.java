package org.lxp.dailylog.service.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.dailylog.config.MemoryDBTest;
import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.LoginService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@MemoryDBTest
public class LoginServiceImplTest {
    @Resource
    private LoginService loginService;

    @Test(expected = CredentialNotMatchException.class)
    public void shouldThrowCredentialNotMatchExceptionWhenWrongCredential() throws CredentialNotMatchException {
        loginService.login("account", "password");
    }

    @Test
    public void testLogin() throws CredentialNotMatchException {
        UserBase userBase = loginService.login("super@1.com", "727dfbdc1a4ee249f3f08c247a5669d5");
        assertEquals("UserBase [Hash = " + userBase.hashCode()
                + ", seqid=1, username=super@1.com, password=NzI3ZGZiZGMxYTRlZTI0OWYzZjA4YzI0N2E1NjY5ZDU7bGVl, lastlogintime=Wed May 30 00:01:45 CDT 2018, createtime=Wed May 30 00:00:00 CDT 2018]",
                userBase.toString());
    }
}

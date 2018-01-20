package org.lxp.dailylog.web.util;

import static org.lxp.dailylog.util.CiphertextUtil.encode;

import java.util.Calendar;

import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.service.NavigatorService;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockTestData {
    private ApplicationContext webApplicationContext;
    private AccountService accountService;
    private NavigatorService navigatorService;
    private UserService userService;

    {
        webApplicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        accountService = webApplicationContext.getBean(AccountService.class);
        navigatorService = webApplicationContext.getBean(NavigatorService.class);
        userService = webApplicationContext.getBean(UserService.class);
    }

    public void createAccount() {
        AccountBase account = new AccountBase();
        account.setUsername("11");
        account.setRemail("11@11.com");
        account.setFpemail("111@11.com");
        account.setPhone("11111");
        account.setProductname("aaaa");
        account.setProducturl("http://11.com");
        account.setJoindate(DateUtil.now());
        account.setCreatetime(DateUtil.now());
        accountService.addAccount(account);
    }

    public void createNavigator() {
        NavigatorBase navigator = new NavigatorBase();
        navigator.setName("222");
        navigator.setTitle("2222");
        navigator.setUrl("http://22.com");
        navigator.setCreatetime(DateUtil.now());
        navigatorService.addNavigator(navigator);
    }

    public void createUser() {
        UserBase user = new UserBase();
        user.setUsername("super@1.com");
        // md5(super1)=727dfbdc1a4ee249f3f08c247a5669d5
        user.setPassword(encode("727dfbdc1a4ee249f3f08c247a5669d5"));
        user.setLastlogintime(Calendar.getInstance().getTime());
        userService.add(user);
    }

    public static void main(String[] args) {
        MockTestData m = new MockTestData();
        m.createAccount();
        m.createNavigator();
        m.createUser();
    }
}

package org.lxp.dailylog.web.util;

import java.util.Calendar;

import org.lxp.dailylog.model.Account;
import org.lxp.dailylog.model.Navigator;
import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.service.NavigatorService;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.service.util.CiphertextUtil;
import org.lxp.dailylog.service.util.DateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sli13
 * @date Aug 16, 2014 9:28:35 AM
 * @version 1.0
 */
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
    Account account = new Account();
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
    Navigator navigator = new Navigator();
    navigator.setName("222");
    navigator.setTitle("2222");
    navigator.setUrl("http://22.com");
    navigator.setCreatetime(DateUtil.now());
    navigatorService.addNavigator(navigator);
  }

  public void createUser() {
    User user = new User();
    user.setUsername("super@1.com");
    // md5(super1)=727dfbdc1a4ee249f3f08c247a5669d5
    user.setPassword(CiphertextUtil.encode(new String[] { "727dfbdc1a4ee249f3f08c247a5669d5", "lee" }));
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

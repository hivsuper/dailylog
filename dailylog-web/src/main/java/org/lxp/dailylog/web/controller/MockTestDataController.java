package org.lxp.dailylog.web.controller;

import static org.lxp.dailylog.util.CiphertextUtil.encode;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.service.NavigatorService;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mockTestData")
public class MockTestDataController {
    @Resource
    private AccountService accountService;
    @Resource
    private NavigatorService navigatorService;
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(method = POST)
    @ApiOperation(value = "添加测试数据")
    public Map<String, Object> index(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("account", createAccount());
        map.put("navigator", createNavigator());
        map.put("user", createUser());
        return map;
    }

    private AccountBase createAccount() {
        AccountBase account = new AccountBase();
        account.setUsername("11");
        account.setRemail("11@11.com");
        account.setFpemail("111@11.com");
        account.setPhone("11111");
        account.setProductname("aaaa");
        account.setProducturl("http://11.com");
        account.setJoindate(DateUtil.now());
        account.setCreatetime(DateUtil.now());
        return accountService.addAccount(account);
    }

    private NavigatorBase createNavigator() {
        NavigatorBase navigator = new NavigatorBase();
        navigator.setName("222");
        navigator.setTitle("2222");
        navigator.setUrl("http://22.com");
        navigator.setCreatetime(DateUtil.now());
        return navigatorService.addNavigator(navigator);
    }

    /**
     * md5(super1)=727dfbdc1a4ee249f3f08c247a5669d5
     */
    private UserBase createUser() {
        UserBase user = new UserBase();
        user.setUsername("super@1.com");
        user.setPassword(encode("727dfbdc1a4ee249f3f08c247a5669d5"));
        user.setLastlogintime(Calendar.getInstance().getTime());
        return userService.add(user);
    }
}

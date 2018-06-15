package org.lxp.dailylog.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.web.util.JsonVo;
import org.lxp.dailylog.web.util.SessionHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private HttpSession session;

    @RequestMapping(value = "/home.json", method = GET)
    @ApiOperation(value = "用户主页")
    public JsonVo<String> home() {
        return JsonVo.success(String.format("Welcome, %s!", SessionHelper.getUser(session).getUsername()));
    }
}

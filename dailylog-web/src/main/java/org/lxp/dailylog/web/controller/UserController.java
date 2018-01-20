package org.lxp.dailylog.web.controller;

import static org.lxp.dailylog.web.util.StringHolder.USER;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.web.util.JsonVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/user")
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private HttpSession session;

    @RequestMapping(value = "/home.json", method = GET)
    @ApiOperation(value = "用户主页")
    public JsonVo<String> home() {
        UserBase user = (UserBase) session.getAttribute(USER);
        return JsonVo.success(String.format("Welcome, %s!", user.getUsername()));
    }
}

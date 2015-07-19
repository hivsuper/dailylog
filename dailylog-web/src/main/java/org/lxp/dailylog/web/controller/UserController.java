package org.lxp.dailylog.web.controller;

import static org.lxp.dailylog.service.util.StringHolder.USER;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @author sli13
 * @date Aug 18, 2014 2:36:44 AM
 * @version 1.0
 */
@Api(value = "/user", description = "用户模块")
@Controller
@RequestMapping("/user")
public class UserController {
  private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
  @Resource
  private UserService userService;
  @Resource
  private HttpSession session;

  @RequestMapping(value = "/home", method = GET)
  @ApiOperation(value = "用户主页")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView("/page/user/home.jsp");
    User user = (User) session.getAttribute(USER);
    mav.addObject(USER, user);
    LOG.debug("home page");
    return mav;
  }
}

package org.lxp.dailylog.web.ctrl;

import javax.servlet.http.HttpSession;

import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.IUserService;
import org.lxp.dailylog.service.util.StringHolder;
import org.lxp.dailylog.web.log.LogInfo;
import org.lxp.dailylog.web.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sli13
 * @date Aug 18, 2014 2:36:44 AM
 * @version 1.0
 */
@Controller
public class UserCtrl {
  private static Logger logger = LoggerFactory.getLogger(LoginCtrl.class);
  @Autowired
  IUserService userService;
  @Autowired
  HttpSession session;

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ModelAndView home() {
    LogInfo logInfo = (LogInfo) session.getAttribute(StringHolder.LOG_INFO);
    ModelAndView mav = new ModelAndView("/page/user/home.jsp");
    User user = (User) session.getAttribute(StringHolder.USER);
    mav.addObject(StringHolder.USER, user);
    logInfo.setUser(user);
    logInfo.setResult("Go to home.jsp!");
    logger.info(LogUtil.getMsgLog(logInfo));
    return mav;
  }
}

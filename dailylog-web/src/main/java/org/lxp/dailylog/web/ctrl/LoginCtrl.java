package org.lxp.dailylog.web.ctrl;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.ILoginService;
import org.lxp.dailylog.service.util.ResultEnum;
import org.lxp.dailylog.service.util.StringHolder;
import org.lxp.dailylog.web.log.LogInfo;
import org.lxp.dailylog.web.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/**
 * 用户登录系统
 * 
 * @author super
 * @since 2012-10-20 下午05:49:06
 * @version 1.0
 */
@Controller
public class LoginCtrl {
  private static Logger logger = LoggerFactory.getLogger(LoginCtrl.class);
  @Autowired
  ILoginService loginService;
  @Autowired
  HttpSession session;

  /**
   * 跳转到登陆页面
   * 
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView toLogin() {
    LogInfo logInfo = (LogInfo) session.getAttribute(StringHolder.LOG_INFO);
    ModelAndView mav = new ModelAndView("/page/login/login.jsp");
    logInfo.setResult("Go to login.jsp!");
    logger.info(LogUtil.getMsgLog(logInfo));
    return mav;
  }

  /**
   * 用户输入账号和密码登录系统，kaptcha
   * useage:http://blog.csdn.net/pandakong/article/details/8799534
   * 
   * @param request
   * @param response
   * @param passwd
   *          密码
   * @param account
   *          用户名
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/login/ajaxLogin", method = RequestMethod.POST)
  public String login(HttpServletRequest request, HttpServletResponse response, String account, String passwd,
      String verifycode) {
    LogInfo logInfo = (LogInfo) session.getAttribute(StringHolder.LOG_INFO);
    Map<String, Object> map = null;
    if (!verifycode.equals(session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY))) {
      map = new HashMap<String, Object>();
      map.put(StringHolder.SUCCESS, StringHolder.FALSE);
      map.put(StringHolder.ERROR_MSG_Content, "Invalid verify code!");
    } else {
      map = loginService.login(account, passwd);
      User user = (User) map.get(StringHolder.USER);
      if (user != null) {
        session.setAttribute(StringHolder.USER, user);
        map.remove(StringHolder.USER);
        logInfo.setResult(account + " login in successfully!");
      } else {
        logInfo.setResult(account + " login in unsuccessfully!");
      }
    }
    logger.info(LogUtil.getMsgLog(logInfo));
    return new Gson().toJson(map).toString();
  }

  /**
   * 用户退出系统返回登录页面
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/login/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response) {
    LogInfo logInfo = (LogInfo) session.getAttribute(StringHolder.LOG_INFO);
    if (session.getAttribute(StringHolder.USER) != null) {
      User user = (User) session.getAttribute(StringHolder.USER);
      logInfo.setResult(user.getUsername() + " logout successfully!");
      logger.info(LogUtil.getMsgLog(logInfo));
      logInfo = new LogInfo();
      session.setAttribute(StringHolder.LOG_INFO, logInfo);
    }
    session.removeAttribute(StringHolder.USER);
    return "redirect:/login";
  }

  /**
   * 输出异常信息
   * 
   * @param enumCode
   * @return
   */
  @RequestMapping("/result/{enumCode}")
  public ModelAndView result(@PathVariable ResultEnum enumCode) {
    ModelAndView mav = new ModelAndView("/page/error/exception.jsp");
    String msgTitle = new String();
    String msgContent = new String();
    switch (enumCode) {
    case NOTLOGIN: {// 权限不足
      msgTitle = String.valueOf(HttpURLConnection.HTTP_FORBIDDEN);
      msgContent = "Sorry, Pls login.";
      break;
    }
    default:
      msgTitle = String.valueOf(HttpURLConnection.HTTP_NOT_FOUND);
      msgContent = "Page is not found.";
      break;
    }
    mav.addObject(StringHolder.ERROR_MSG_Title, msgTitle);
    mav.addObject(StringHolder.ERROR_MSG_Content, msgContent);
    return mav;
  }
}

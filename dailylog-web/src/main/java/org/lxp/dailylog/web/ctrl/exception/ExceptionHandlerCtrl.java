package org.lxp.dailylog.web.ctrl.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.service.util.ResultEnum;
import org.lxp.dailylog.service.util.StringHolder;
import org.lxp.dailylog.web.log.LogInfo;
import org.lxp.dailylog.web.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author super 异常处理类
 * @version 22 Apr 2012
 */
@Controller
public class ExceptionHandlerCtrl implements HandlerExceptionResolver {
  private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerCtrl.class);
  @Autowired
  HttpSession session;

  /**
   * 统一的异常处理，把异常信息写入日志
   * 
   * @author super
   * @param request
   *          出现异常的请求
   * @param response
   * @param obj
   * @param exception
   *          出现异常的对象
   */
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
      Exception exception) {
    LogInfo logInfo = (LogInfo) session.getAttribute(StringHolder.LOG_INFO);
    exception.printStackTrace();
    logInfo.setResult(exception.getMessage());
    logger.info(LogUtil.getMsgLog(logInfo));
    return new ModelAndView("redirect:/result/" + ResultEnum.ERROR);
  }
}

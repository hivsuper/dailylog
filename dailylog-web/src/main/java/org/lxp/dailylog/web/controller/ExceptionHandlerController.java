package org.lxp.dailylog.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @author super
 * @version 22 Apr 2012
 */
@Controller
public class ExceptionHandlerController implements HandlerExceptionResolver {
  private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);
  @Resource
  private HttpSession session;

  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
      Exception exception) {
    LOG.error(exception.getMessage(), exception);
    return new ModelAndView("redirect:/404");
  }

  @RequestMapping(value = "/404", method = GET)
  @ApiOperation(value = "404")
  public ModelAndView _404() {
    return new ModelAndView("/page/error/exception.jsp");
  }
}

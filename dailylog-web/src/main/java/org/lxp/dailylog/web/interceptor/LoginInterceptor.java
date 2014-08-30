package org.lxp.dailylog.web.interceptor;

import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.service.util.ResultEnum;
import org.lxp.dailylog.service.util.StringHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录拦截器
 * 
 * @author super
 * @version 17 Feb 2012
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
  private Set<String> excludes;
  private Set<String> excludePaths;
  private String ajaxPath;

  /**
   * 具体controller方法调用前调用
   * 
   * @param request
   * @param response
   * @param handler
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    boolean result = true;
    HttpSession session = request.getSession();
    String uri = request.getServletPath();
    if (uri.endsWith("/")) {
      response.sendRedirect(request.getContextPath() + uri.substring(0, uri.length() - 1));
    } else if (this.exclude(uri)) {
      result = true;
    } else {
      boolean isLogin = session.getAttribute(StringHolder.USER) != null;
      if (uri.contains(ajaxPath) && !isLogin) {
        PrintWriter out = response.getWriter();
        out.write(ResultEnum.NOTLOGIN.toString());
        out.flush();
      } else {
        if (!isLogin) {
          response.sendRedirect(request.getContextPath() + "/result/" + ResultEnum.NOTLOGIN.toString());
        } else {
          result = isLogin;
        }
      }
    }
    return result;
  }

  private boolean exclude(String uri) {
    for (String path : excludes) {
      if (uri.endsWith(path)) {
        return true;
      }
    }
    for (String path : excludePaths) {
      if (uri.contains(path)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 具体controller方法调用前调用
   * 
   * @param request
   * @param response
   * @param handler
   * @param mav
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
      throws Exception {
  }

  public Set<String> getExcludes() {
    return excludes;
  }

  public void setExcludes(Set<String> excludes) {
    this.excludes = excludes;
  }

  public Set<String> getExcludePaths() {
    return excludePaths;
  }

  public void setExcludePaths(Set<String> excludePaths) {
    this.excludePaths = excludePaths;
  }

  public String getAjaxPath() {
    return ajaxPath;
  }

  public void setAjaxPath(String ajaxPath) {
    this.ajaxPath = ajaxPath;
  }
}

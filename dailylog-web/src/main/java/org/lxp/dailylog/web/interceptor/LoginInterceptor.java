package org.lxp.dailylog.web.interceptor;

import static org.lxp.dailylog.service.util.StringHolder.USER;

import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author super
 * @version 17 Feb 2012
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
  private Set<String> excludes;
  private Set<String> excludePaths;
  private String ajaxPath;
  private static final String SLASH = "/";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    boolean result = true;
    String uri = request.getServletPath();
    if (!SLASH.equals(uri)) {
      HttpSession session = request.getSession();
      if (uri.endsWith(SLASH)) {
        response.sendRedirect(request.getContextPath() + uri.substring(0, uri.length() - 1));
      } else if (this.exclude(uri)) {
        result = true;
      } else {
        boolean isLogin = session.getAttribute(USER) != null;
        if (uri.endsWith(ajaxPath) && !isLogin) {
          PrintWriter out = response.getWriter();
          out.write("403");
          out.flush();
        } else {
          if (!isLogin) {
            response.sendRedirect(request.getContextPath() + "/404");
          } else {
            result = isLogin;
          }
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

package org.lxp.dailylog.web.interceptor;

import static org.lxp.dailylog.web.util.StringHolder.USER;

import java.io.PrintWriter;

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
  private String ajaxPath;
  private static final String SLASH = "/";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    boolean result = true;
    String uri = request.getServletPath();
    HttpSession session = request.getSession();
    if (uri.endsWith(SLASH)) {
      response.sendRedirect(request.getContextPath() + uri.substring(0, uri.length() - 1));
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
    return result;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
      throws Exception {
  }

  public String getAjaxPath() {
    return ajaxPath;
  }

  public void setAjaxPath(String ajaxPath) {
    this.ajaxPath = ajaxPath;
  }
}

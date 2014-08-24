package org.lxp.dailylog.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.service.util.StringHolder;
import org.lxp.dailylog.web.log.LogInfo;
import org.lxp.dailylog.web.log.LogUtil;

public class LogFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
      ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    initLoginfo(req);
    chain.doFilter(req, resp);
  }

  @Override
  public void destroy() {

  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {

  }

  /**
   * 日志过滤器信息的初始化方法
   * 
   * @param req
   */
  @SuppressWarnings("unchecked")
  private void initLoginfo(HttpServletRequest req) {
    HttpSession session = req.getSession();
    LogInfo loginfo = (LogInfo) session.getAttribute(StringHolder.LOG_INFO);
    if (null == loginfo) {
      loginfo = new LogInfo();
      session.setAttribute(StringHolder.LOG_INFO, loginfo);
    }
    loginfo.setAciton(req.getServletPath());
    loginfo = LogUtil.setArgsLog(loginfo, req.getParameterMap());
    loginfo.setIp(req.getRemoteAddr());
  }
}

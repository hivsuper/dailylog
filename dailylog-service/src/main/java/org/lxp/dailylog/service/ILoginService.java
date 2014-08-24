package org.lxp.dailylog.service;

import java.util.Map;

/**
 * 登录服务接口
 * 
 * @author super
 */
public interface ILoginService {

  /**
   * 登录
   * 
   * @param account
   * @param passwd
   * @return
   */
  public Map<String, Object> login(String account, String passwd);
}

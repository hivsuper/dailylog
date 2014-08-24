package org.lxp.dailylog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.ILoginService;
import org.lxp.dailylog.service.IUserService;
import org.lxp.dailylog.service.util.CiphertextUtil;
import org.lxp.dailylog.service.util.StringHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
  @Autowired
  private IUserService userService;

  /**
   * 登录
   * 
   * @param account
   *          用户名
   * @param passwd
   *          密码，采用base64加密方式
   * @return
   */
  @Override
  public Map<String, Object> login(String account, String passwd) {
    Map<String, Object> map = new HashMap<String, Object>();
    User user = userService.queryOneUserByUsername(account);
    if (user == null) {
      map.put(StringHolder.SUCCESS, StringHolder.FALSE);
      map.put(StringHolder.ERROR_MSG_Content, account + " doesn't exist!");
    } else if (user.getUsername().equals(account) && CiphertextUtil.decode(user.getPassword())[0].equals(passwd)) {
      map.put(StringHolder.SUCCESS, StringHolder.TRUE);
      map.put(StringHolder.USER, user);
    } else {
      map.put(StringHolder.SUCCESS, StringHolder.FALSE);
      map.put(StringHolder.ERROR_MSG_Content, "Invalid username or password!");
    }
    return map;
  }
}

package org.lxp.dailylog.service.impl;

import static org.lxp.dailylog.service.util.CiphertextUtil.decode;

import javax.annotation.Resource;

import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.LoginService;
import org.lxp.dailylog.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
  @Resource
  private UserService userService;

  @Override
  public User login(String account, String passwd) throws CredentialNotMatchException {
    User user = userService.queryOneUserByUsername(account);
    if (!decode(user.getPassword())[0].equals(passwd)) {
      throw new CredentialNotMatchException(String.format("%s%s", account, "用户名或密码不正确"));
    }
    return user;
  }
}

package org.lxp.dailylog.service.impl;

import static org.lxp.dailylog.service.util.CiphertextUtil.encode;

import javax.annotation.Resource;

import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.LoginService;
import org.lxp.dailylog.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
  @Resource
  private UserService userService;

  @Override
  public UserBase login(String account, String password) throws CredentialNotMatchException {
    UserBase user = userService.queryOneUserByUsername(account);
    if (user == null || !encode(password).equals(user.getPassword())) {
      throw new CredentialNotMatchException(String.format("%s%s", account, "用户名或密码不正确"));
    }
    return user;
  }
}

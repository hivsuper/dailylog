package org.lxp.dailylog.service;

import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.model.User;

/**
 * 登录服务接口
 * 
 * @author super
 */
public interface LoginService {

  public User login(String account, String passwd) throws CredentialNotMatchException;
}

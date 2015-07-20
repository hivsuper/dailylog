package org.lxp.dailylog.service;

import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.model.UserBase;

/**
 * 登录服务接口
 * 
 * @author super
 */
public interface LoginService {

  public UserBase login(String account, String password) throws CredentialNotMatchException;
}

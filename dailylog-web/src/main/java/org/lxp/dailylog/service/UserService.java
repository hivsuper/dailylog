package org.lxp.dailylog.service;

import org.lxp.dailylog.model.UserBase;

/**
 * @author super
 * @since 2013-4-22 下午5:47:54
 * @version 1.0
 */
public interface UserService {
  public void add(UserBase user);

  public UserBase queryOneUserByUsername(String username);
}

package org.lxp.dailylog.service;

import org.lxp.dailylog.model.User;

/**
 * @author super
 * @since 2013-4-22 下午5:47:54
 * @version 1.0
 */
public interface UserService {
  /**
   * 添加一个用户
   * 
   * @param user
   *          待添加用户对象
   * @return
   */
  public void add(User user);

  /**
   * 按用户名查询用户
   * 
   * @param username
   *          用户名
   * @return
   */
  public User queryOneUserByUsername(String username);
}

package org.lxp.dailylog.service.impl;

import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.IUserService;
import org.lxp.dailylog.service.dao.UserDao;
import org.lxp.dailylog.service.util.ConvertSqlUtil;
import org.lxp.dailylog.service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author super
 * @since 2013-4-22 下午5:50:56
 * @version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  private UserDao userDao;

  /**
   * 添加一个用户
   * 
   * @param user
   *          待添加用户对象
   * @return
   */
  @Override
  public void add(User user) {
    user.setCreatetime(DateUtil.now());
    userDao.insert(user);
  }

  /**
   * 按用户名查询用户
   * 
   * @param username
   *          用户名
   * @return
   */
  @Override
  public User queryOneUserByUsername(String username) {
    return userDao.queryOne("username LIKE ?", "%" + ConvertSqlUtil.convertSql(username) + "%");
  }

}

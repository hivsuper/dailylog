package org.lxp.dailylog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.IUserService;
import org.lxp.dailylog.service.mapper.AccountMapper;
import org.lxp.dailylog.service.mapper.NavigatorMapper;
import org.lxp.dailylog.service.mapper.UserMapper;
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
  private UserMapper userMapper;
  @Autowired
  private AccountMapper accountMapper;
  @Autowired
  private NavigatorMapper navigatorMapper;

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
    userMapper.add(user);
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
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("username", username);
    Map<String, Object> map2 = new HashMap<String, Object>();
    Map<String, Object> map3 = new HashMap<String, Object>();
    map2.put("username", "1");
    accountMapper.queryOne(map2);
    map3.put("name", "2");
    navigatorMapper.queryOne(map3);
    return userMapper.queryOne(map);
  }

}

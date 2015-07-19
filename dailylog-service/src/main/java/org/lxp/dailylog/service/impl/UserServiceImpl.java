package org.lxp.dailylog.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.lxp.dailylog.model.User;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.service.mapper.UserMapper;
import org.lxp.dailylog.service.util.DateUtil;
import org.springframework.stereotype.Service;

/**
 * @author super
 * @since 2013-4-22 下午5:50:56
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
  @Resource
  private UserMapper userMapper;

  @Override
  public void add(User user) {
    user.setCreatetime(DateUtil.now());
    userMapper.add(user);
  }

  @Override
  public User queryOneUserByUsername(String username) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("username", username);
    return userMapper.queryOne(map);
  }

}

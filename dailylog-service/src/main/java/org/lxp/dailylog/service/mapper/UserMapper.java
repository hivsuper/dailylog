package org.lxp.dailylog.service.mapper;

import java.util.Map;

import org.lxp.dailylog.model.User;

/**
 * @author sli13
 * @date Aug 25, 2014 4:42:23 AM
 * @version 1.0
 */
public interface UserMapper {
  public void add(User user);

  public User queryOne(Map<String, Object> map);
}

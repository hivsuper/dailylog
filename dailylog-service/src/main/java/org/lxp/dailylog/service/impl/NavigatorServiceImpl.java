package org.lxp.dailylog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.lxp.dailylog.model.Navigator;
import org.lxp.dailylog.service.INavigatorService;
import org.lxp.dailylog.service.mapper.NavigatorMapper;
import org.lxp.dailylog.service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author super
 * @since 2013年11月8日上午12:58:51
 * @version 1.0
 */
@Service
public class NavigatorServiceImpl implements INavigatorService {
  @Autowired
  private NavigatorMapper navigatorMapper;

  @Override
  public void addNavigator(Navigator navigator) {
    navigator.setCreatetime(DateUtil.now());
    navigatorMapper.add(navigator);
  }

  @Override
  public Navigator queryOneByLike(String keyword) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", keyword);
    map.put("url", keyword);
    map.put("title", keyword);
    return navigatorMapper.queryOne(map);
  }

}

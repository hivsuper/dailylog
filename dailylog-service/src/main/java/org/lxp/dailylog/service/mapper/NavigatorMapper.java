package org.lxp.dailylog.service.mapper;

import java.util.Map;

import org.lxp.dailylog.model.Navigator;

/**
 *@author sli13
 *@date Aug 25, 2014 4:41:30 AM
 *@version 1.0
 */
public interface NavigatorMapper {
  public void add(Navigator navigator);

  public Navigator queryOne(Map<String, Object> map);
}

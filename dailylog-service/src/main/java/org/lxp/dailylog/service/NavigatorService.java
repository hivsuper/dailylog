package org.lxp.dailylog.service;

import org.lxp.dailylog.model.Navigator;

/**
 * @author super
 * @since 2013年11月8日上午12:42:41
 * @version 1.0
 */
public interface NavigatorService {
  public void addNavigator(Navigator navigator);

  public Navigator queryOneByLike(String keyword);
}

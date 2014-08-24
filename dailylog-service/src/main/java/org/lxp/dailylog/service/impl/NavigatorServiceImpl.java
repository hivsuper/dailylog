package org.lxp.dailylog.service.impl;

import org.lxp.dailylog.model.Navigator;
import org.lxp.dailylog.service.INavigatorService;
import org.lxp.dailylog.service.dao.NavigatorDao;
import org.lxp.dailylog.service.util.ConvertSqlUtil;
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
  private NavigatorDao navigatorDao;

  @Override
  public void addNavigator(Navigator navigator) {
    navigator.setCreatetime(DateUtil.now());
    navigatorDao.add(navigator);
  }

  @Override
  public Navigator queryOneByLike(String keyword) {
    StringBuffer whereSql = new StringBuffer("name LIKE ? OR url LIKE ? OR title LIKE ?");
    keyword = "%" + ConvertSqlUtil.convertSql(keyword) + "%";
    Object[] params = new Object[] { keyword, keyword, keyword };
    return navigatorDao.queryOne(whereSql.toString(), params);
  }

}

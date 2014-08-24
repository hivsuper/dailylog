package org.lxp.dailylog.service.dao;

import org.lxp.dailylog.model.Navigator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author super
 * @since 2013年11月8日上午12:34:58
 * @version 1.0
 */
@Component
public class NavigatorDao extends BaseDao<Navigator> {
  public void add(Navigator navigator) {
    StringBuffer sql = new StringBuffer("INSERT INTO navigator(name, url, title, createtime) VALUES(?,?,?,?)");
    excuteSqlWithKeyHolder(sql.toString(), new Object[] { navigator.getName(), navigator.getUrl(),
        navigator.getTitle(), navigator.getCreatetime() });
  }

  public Navigator queryOne(String whereSql, Object... params) {
    StringBuffer sql = new StringBuffer("SELECT seqid, name, url, title, createtime FROM navigator");
    if (StringUtils.hasLength(whereSql)) {
      sql.append(" WHERE ").append(whereSql);
    }
    sql.append(" LIMIT 0,1");
    return queryOneWithKeyHolder(Navigator.class, sql.toString(), params);
  }
}

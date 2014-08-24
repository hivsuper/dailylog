package org.lxp.dailylog.service.dao;

import org.lxp.dailylog.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author super
 * @since 2013-4-22 下午5:20:18
 * @version 1.0
 */
@Component
public class UserDao extends BaseDao<User> {
  /**
   * 添加用户
   * 
   * @param user
   *          待添加用户信息
   */
  public void insert(User user) {
    StringBuffer sql = new StringBuffer("INSERT INTO user(username, password, createtime) VALUES(?, ?, ?)");
    excuteSqlWithKeyHolder(sql.toString(),
        new Object[] { user.getUsername(), user.getPassword(), user.getCreatetime() });
  }

  /**
   * 按条件查询一个用户
   * 
   * @param whereSql
   *          查询条件
   * @param params
   *          参数列表
   * @return
   */
  public User queryOne(String whereSql, Object... params) {
    StringBuffer sql = new StringBuffer("SELECT seqid, username, password, lastlogintime, createtime FROM user");
    if (StringUtils.hasLength(whereSql)) {
      sql.append(" WHERE ").append(whereSql);
    }
    sql.append(" LIMIT 0,1");
    return queryOneWithKeyHolder(User.class, sql.toString(), params);
  }
}

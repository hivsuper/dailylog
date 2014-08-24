package org.lxp.dailylog.service.dao;

import org.lxp.dailylog.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author super
 * @since 2013年11月8日上午12:21:17
 * @version 1.0
 */
@Component
public class AccountDao extends BaseDao<Account> {
  public void add(Account account) {
    StringBuffer sql = new StringBuffer(
        "INSERT INTO account(username, remail, fpemail, phone, productname, producturl, joindate, createtime)"
            + " VALUES(?,?,?,?,?,?,?,?)");
    excuteSqlWithKeyHolder(
        sql.toString(),
        new Object[] { account.getUsername(), account.getRemail(), account.getFpemail(), account.getPhone(),
            account.getProductname(), account.getProducturl(), account.getJoindate(), account.getCreatetime() });
  }

  public Account queryOne(String whereSql, Object... params) {
    StringBuffer sql = new StringBuffer(
        "SELECT seqid, username, remail, fpemail, phone, productname, producturl, joindate, createtime FROM account");
    if (StringUtils.hasLength(whereSql)) {
      sql.append(" WHERE ").append(whereSql);
    }
    sql.append(" LIMIT 0,1");
    return queryOneWithKeyHolder(Account.class, sql.toString(), params);
  }
}

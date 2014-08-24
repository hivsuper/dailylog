package org.lxp.dailylog.service.impl;

import org.lxp.dailylog.model.Account;
import org.lxp.dailylog.service.IAccountService;
import org.lxp.dailylog.service.dao.AccountDao;
import org.lxp.dailylog.service.util.ConvertSqlUtil;
import org.lxp.dailylog.service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author super
 * @since 2013年11月8日上午12:49:52
 * @version 1.0
 */
@Service
public class AccountServiceImpl implements IAccountService {
  @Autowired
  private AccountDao accountDao;

  @Override
  public void addAccount(Account account) {
    account.setCreatetime(DateUtil.now());
    accountDao.add(account);
  }

  @Override
  public Account queryOneLike(String keyword) {
    StringBuffer whereSql = new StringBuffer(
        "username LIKE ? OR remail LIKE ? OR phone LIKE ? OR productname LIKE ? OR producturl LIKE ?");
    keyword = "%" + ConvertSqlUtil.convertSql(keyword) + "%";
    Object[] params = new Object[] { keyword, keyword, keyword, keyword, keyword };
    return accountDao.queryOne(whereSql.toString(), params);
  }
}

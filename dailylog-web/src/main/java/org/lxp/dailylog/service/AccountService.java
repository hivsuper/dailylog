package org.lxp.dailylog.service;

import org.lxp.dailylog.model.AccountBase;

/**
 * @author super
 * @since 2013年11月8日上午12:44:15
 * @version 1.0
 */
public interface AccountService {
  public void addAccount(AccountBase account);

  public AccountBase queryOneLike(String keyword);
}

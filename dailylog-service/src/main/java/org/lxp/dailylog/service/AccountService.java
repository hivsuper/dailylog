package org.lxp.dailylog.service;

import org.lxp.dailylog.model.Account;

/**
 * @author super
 * @since 2013年11月8日上午12:44:15
 * @version 1.0
 */
public interface AccountService {
  public void addAccount(Account account);

  public Account queryOneLike(String keyword);
}

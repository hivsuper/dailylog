package org.lxp.dailylog.service.mapper;

import java.util.Map;

import org.lxp.dailylog.model.Account;

/**
 * @author sli13
 * @date Aug 25, 2014 4:39:31 AM
 * @version 1.0
 */
public interface AccountMapper {
  public void add(Account account);

  public Account queryOne(Map<String, Object> map);
}

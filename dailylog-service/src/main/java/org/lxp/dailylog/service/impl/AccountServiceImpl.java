package org.lxp.dailylog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.lxp.dailylog.model.Account;
import org.lxp.dailylog.service.IAccountService;
import org.lxp.dailylog.service.mapper.AccountMapper;
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
  private AccountMapper accountMapper;

  @Override
  public void addAccount(Account account) {
    account.setCreatetime(DateUtil.now());
    accountMapper.add(account);
  }

  @Override
  public Account queryOneLike(String keyword) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("username", keyword);
    map.put("remail", keyword);
    map.put("fpemail", keyword);
    map.put("productname", keyword);
    map.put("producturl", keyword);
    return accountMapper.queryOne(map);
  }
}

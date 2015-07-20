package org.lxp.dailylog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lxp.dailylog.dao.mapper.AccountBaseMapper;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.model.AccountBaseExample;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.stereotype.Service;

/**
 * @author super
 * @since 2013年11月8日上午12:49:52
 * @version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {
  @Resource
  private AccountBaseMapper accountBaseMapper;

  @Override
  public void addAccount(AccountBase account) {
    account.setCreatetime(DateUtil.now());
    accountBaseMapper.insertSelective(account);
  }

  @Override
  public AccountBase queryOneLike(String keyword) {
    AccountBaseExample example = new AccountBaseExample();
    keyword = String.format("%%%s%%", keyword);
    example.createCriteria().andUsernameLike(keyword);
    example.or(example.createCriteria().andRemailLike(keyword));
    example.or(example.createCriteria().andFpemailLike(keyword));
    example.or(example.createCriteria().andProductnameLike(keyword));
    example.or(example.createCriteria().andProducturlLike(keyword));
    List<AccountBase> list = accountBaseMapper.selectByExample(example);
    return (list != null && !list.isEmpty()) ? list.get(0) : null;
  }
}

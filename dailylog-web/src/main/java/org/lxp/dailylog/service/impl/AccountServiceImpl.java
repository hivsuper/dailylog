package org.lxp.dailylog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lxp.dailylog.dao.mapper.AccountBaseMapper;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.model.AccountBaseExample;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountBaseMapper accountBaseMapper;

    @Override
    public void addAccount(AccountBase account) {
        account.setCreatetime(DateUtil.now());
        accountBaseMapper.insertSelective(account);
    }

    @Override
    public AccountBase addAccount(String userName, String rEmail, String fpEmail, String phone, String productName,
            String productUrl) {
        AccountBase account = new AccountBase();
        account.setUsername(userName);
        account.setRemail(rEmail);
        account.setFpemail(fpEmail);
        account.setPhone(phone);
        account.setProductname(productName);
        account.setProducturl(productUrl);
        account.setJoindate(DateUtil.now());
        account.setCreatetime(DateUtil.now());
        account.setCreatetime(DateUtil.now());
        accountBaseMapper.insertSelective(account);
        LOG.info("add accountId={}", account.getSeqid());
        return account;
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

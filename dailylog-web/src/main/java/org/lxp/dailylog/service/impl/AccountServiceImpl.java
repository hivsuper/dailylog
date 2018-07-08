package org.lxp.dailylog.service.impl;

import org.lxp.dailylog.dao.mapper.AccountBaseMapper;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.model.AccountBaseExample;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.util.DateUtil;
import org.lxp.dailylog.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountBaseMapper accountBaseMapper;

    @Override
    public AccountBase addAccount(String userName, String rEmail, String fpEmail, String phone, String productName,
                                  String productUrl, LocalDate joinDate) {
        AccountBase account = new AccountBase();
        account.setUsername(userName);
        account.setRemail(rEmail);
        account.setFpemail(fpEmail);
        account.setPhone(phone);
        account.setProductname(productName);
        account.setProducturl(productUrl);
        account.setJoindate(DateUtil.localDateToDate(joinDate));
        account.setCreatetime(DateUtil.now());
        accountBaseMapper.insertSelective(account);
        LOG.info("add accountId={}", account.getSeqid());
        return account;
    }

    @Override
    public Page<AccountBase> queryAccountPage(String keyword, int currentPage, int pageSize) {
        AccountBaseExample example = new AccountBaseExample();
        keyword = String.format("%%%s%%", keyword);
        example.createCriteria().andUsernameLike(keyword);
        example.or(example.createCriteria().andRemailLike(keyword));
        example.or(example.createCriteria().andFpemailLike(keyword));
        example.or(example.createCriteria().andProductnameLike(keyword));
        example.or(example.createCriteria().andProducturlLike(keyword));

        Page<AccountBase> page = new Page<>(currentPage, pageSize);
        example.setOffset(page.getOffset());
        example.setLimit(page.getPageSize());
        page.setObjs(accountBaseMapper.selectByExample(example));
        return page;
    }
}

package org.lxp.dailylog.service.impl;

import org.lxp.dailylog.dao.mapper.NavigatorBaseMapper;
import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.model.NavigatorBaseExample;
import org.lxp.dailylog.service.NavigatorService;
import org.lxp.dailylog.util.DateUtil;
import org.lxp.dailylog.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NavigatorServiceImpl implements NavigatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NavigatorServiceImpl.class);
    @Resource
    private NavigatorBaseMapper navigatorBaseMapper;

    @Override
    public NavigatorBase addNavigator(NavigatorBase navigator) {
        navigator.setCreatetime(DateUtil.now());
        navigatorBaseMapper.insertSelective(navigator);
        LOGGER.info("add navigator id={}", navigator.getSeqid());
        return navigator;
    }

    @Override
    public Page<NavigatorBase> queryNavigatorPage(String keyword, int currentPage, int pageSize) {
        NavigatorBaseExample example = new NavigatorBaseExample();
        keyword = String.format("%%%s%%", keyword);
        example.createCriteria().andNameLike(keyword);
        example.or(example.createCriteria().andUrlLike(keyword));
        example.or(example.createCriteria().andTitleLike(keyword));

        Page<NavigatorBase> page = new Page<>(currentPage, pageSize);
        example.setOffset(page.getOffset());
        example.setLimit(page.getPageSize());
        page.setObjs(navigatorBaseMapper.selectByExample(example));
        return page;
    }
}

package org.lxp.dailylog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.model.NavigatorBaseExample;
import org.lxp.dailylog.service.NavigatorService;
import org.lxp.dailylog.service.mapper.NavigatorBaseMapper;
import org.lxp.dailylog.service.util.DateUtil;
import org.springframework.stereotype.Service;

/**
 * @author super
 * @since 2013年11月8日上午12:58:51
 * @version 1.0
 */
@Service
public class NavigatorServiceImpl implements NavigatorService {
  @Resource
  private NavigatorBaseMapper navigatorBaseMapper;

  @Override
  public void addNavigator(NavigatorBase navigator) {
    navigator.setCreatetime(DateUtil.now());
    navigatorBaseMapper.insertSelective(navigator);
  }

  @Override
  public NavigatorBase queryOneByLike(String keyword) {
    NavigatorBaseExample example = new NavigatorBaseExample();
    keyword = String.format("%%%s%%", keyword);
    example.createCriteria().andNameLike(keyword);
    example.or(example.createCriteria().andUrlLike(keyword));
    example.or(example.createCriteria().andTitleLike(keyword));
    List<NavigatorBase> list = navigatorBaseMapper.selectByExample(example);
    return (list != null && !list.isEmpty()) ? list.get(0) : null;
  }
}

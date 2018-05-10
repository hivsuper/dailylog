package org.lxp.dailylog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lxp.dailylog.dao.mapper.UserBaseMapper;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.model.UserBaseExample;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserBaseMapper userBaseMapper;

    @Override
    public UserBase add(UserBase user) {
        user.setCreatetime(DateUtil.now());
        userBaseMapper.insertSelective(user);
        LOGGER.info("add userId={}", user.getSeqid());
        return user;
    }

    @Override
    public UserBase queryOneUserByUsername(String username) {
        UserBaseExample example = new UserBaseExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserBase> list = userBaseMapper.selectByExample(example);
        return (list != null && !list.isEmpty()) ? list.get(0) : null;
    }

}

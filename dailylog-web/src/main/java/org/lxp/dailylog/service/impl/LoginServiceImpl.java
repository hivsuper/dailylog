package org.lxp.dailylog.service.impl;

import org.lxp.dailylog.dao.mapper.UserBaseMapper;
import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.LoginService;
import org.lxp.dailylog.service.UserService;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.lxp.dailylog.util.CiphertextUtil.encode;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserService userService;
    @Resource
    private UserBaseMapper userBaseMapper;

    @Override
    public UserBase login(String account, String password) throws CredentialNotMatchException {
        UserBase user = userService.queryOneUserByUsername(account);
        if (user == null || !encode(password).equals(user.getPassword())) {
            throw new CredentialNotMatchException(String.format("%s%s", account, "用户名或密码不正确"));
        }
        UserBase tmp = new UserBase();
        tmp.setSeqid(user.getSeqid());
        tmp.setLastlogintime(DateUtil.now());
        userBaseMapper.updateByPrimaryKeySelective(tmp);
        return user;
    }
}

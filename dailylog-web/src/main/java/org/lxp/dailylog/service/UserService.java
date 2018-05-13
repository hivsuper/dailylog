package org.lxp.dailylog.service;

import org.lxp.dailylog.model.UserBase;

public interface UserService {
    UserBase add(UserBase user);

    UserBase queryOneUserByUsername(String username);
}

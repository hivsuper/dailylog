package org.lxp.dailylog.service;

import org.lxp.dailylog.model.UserBase;

public interface UserService {
    public void add(UserBase user);

    public UserBase queryOneUserByUsername(String username);
}

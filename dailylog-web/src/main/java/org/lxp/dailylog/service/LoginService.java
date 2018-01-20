package org.lxp.dailylog.service;

import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.model.UserBase;

public interface LoginService {
    public UserBase login(String account, String password) throws CredentialNotMatchException;
}

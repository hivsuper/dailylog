package org.lxp.dailylog.service;

import org.lxp.dailylog.model.AccountBase;

public interface AccountService {
    public void addAccount(AccountBase account);

    public AccountBase queryOneLike(String keyword);
}

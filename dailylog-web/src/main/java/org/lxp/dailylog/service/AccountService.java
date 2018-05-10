package org.lxp.dailylog.service;

import org.lxp.dailylog.model.AccountBase;

public interface AccountService {
    public AccountBase addAccount(AccountBase account);

    public AccountBase addAccount(String userName, String rEmail, String fpEmail, String phone, String productName,
            String productUrl);

    public AccountBase queryOneLike(String keyword);
}

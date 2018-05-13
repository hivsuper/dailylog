package org.lxp.dailylog.service;

import org.lxp.dailylog.model.AccountBase;

public interface AccountService {
    AccountBase addAccount(AccountBase account, boolean rollback);

    AccountBase addAccount(String userName, String rEmail, String fpEmail, String phone, String productName,
            String productUrl);

    AccountBase queryOneLike(String keyword);
}

package org.lxp.dailylog.service;

import org.lxp.dailylog.model.AccountBase;

import java.time.LocalDate;

public interface AccountService {
    AccountBase addAccount(String userName, String rEmail, String fpEmail, String phone, String productName,
                           String productUrl, LocalDate joinDate);

    AccountBase queryOneLike(String keyword);
}

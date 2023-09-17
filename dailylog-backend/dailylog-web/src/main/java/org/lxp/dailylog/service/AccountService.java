package org.lxp.dailylog.service;

import java.time.LocalDate;

import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.util.Page;

public interface AccountService {
    AccountBase addAccount(String username, String rEmail, String fpEmail, String phone, String productName,
            String productUrl, LocalDate joinDate);

    Page<AccountBase> queryAccountPage(String keyword, String draw, int start, int pageSize);
}

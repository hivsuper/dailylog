package org.lxp.dailylog.service;

import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.util.Page;

public interface NavigatorService {
    NavigatorBase addNavigator(NavigatorBase navigator);

    Page<NavigatorBase> queryNavigatorPage(String keyword, int currentPage, int pageSize);
}

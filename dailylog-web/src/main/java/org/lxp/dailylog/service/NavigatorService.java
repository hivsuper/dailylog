package org.lxp.dailylog.service;

import org.lxp.dailylog.model.NavigatorBase;

public interface NavigatorService {
    public NavigatorBase addNavigator(NavigatorBase navigator);

    public NavigatorBase queryOneByLike(String keyword);
}

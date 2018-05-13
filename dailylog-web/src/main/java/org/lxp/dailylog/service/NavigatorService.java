package org.lxp.dailylog.service;

import org.lxp.dailylog.model.NavigatorBase;

public interface NavigatorService {
    NavigatorBase addNavigator(NavigatorBase navigator);

    NavigatorBase queryOneByLike(String keyword);
}

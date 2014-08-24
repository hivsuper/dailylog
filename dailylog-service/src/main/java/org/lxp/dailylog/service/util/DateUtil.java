package org.lxp.dailylog.service.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author super
 * @since 2013年11月8日上午12:51:21
 * @version 1.0
 */
public class DateUtil {
  public static Date now() {
    return Calendar.getInstance().getTime();
  }

  public static void main(String[] args) {
    System.out.println(DateUtil.now());
  }
}

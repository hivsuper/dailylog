package org.lxp.dailylog.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Super.Li
 * @since 2015年7月19日
 */
public class DateUtilTest {

  @Test
  public void testNow() {
    Assert.assertNotNull(DateUtil.now());
  }

}

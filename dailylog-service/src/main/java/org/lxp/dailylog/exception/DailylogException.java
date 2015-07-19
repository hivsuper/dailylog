package org.lxp.dailylog.exception;

/**
 * @author Super.Li
 * @since 2015年7月19日
 */
public abstract class DailylogException extends Exception {
  private static final long serialVersionUID = 1L;

  public DailylogException(String msg) {
    super(msg);
  }

  public abstract int getCode();
}

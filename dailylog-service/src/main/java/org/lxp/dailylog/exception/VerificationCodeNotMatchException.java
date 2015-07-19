package org.lxp.dailylog.exception;

import static org.lxp.dailylog.exception.CodeHolder.VERIFICATION_CODE_NOT_MATCH;

/**
 * @author Super.Li
 * @since 2015年7月19日
 */
public class VerificationCodeNotMatchException extends DailylogException {
  private static final long serialVersionUID = 1L;

  public VerificationCodeNotMatchException(String msg) {
    super(msg);
  }

  @Override
  public int getCode() {
    return VERIFICATION_CODE_NOT_MATCH;
  }

}

package org.lxp.dailylog.exception;

import static org.lxp.dailylog.exception.CodeHolder.CREDENTIAL_NOT_MATCH;

/**
 * @author Super.Li
 * @since 2015年7月19日
 */
public class CredentialNotMatchException extends DailylogException {
  private static final long serialVersionUID = 1L;

  public CredentialNotMatchException(String msg) {
    super(msg);
  }

  public int getCode() {
    return CREDENTIAL_NOT_MATCH;
  }

}

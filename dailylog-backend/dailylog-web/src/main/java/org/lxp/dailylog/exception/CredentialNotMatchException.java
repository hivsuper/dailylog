package org.lxp.dailylog.exception;

import static org.lxp.dailylog.exception.CodeEnum.CREDENTIAL_NOT_MATCH;

public class CredentialNotMatchException extends DailylogException {
    private static final long serialVersionUID = 1L;

    public CredentialNotMatchException(String msg) {
        super(CREDENTIAL_NOT_MATCH, msg);
    }
}

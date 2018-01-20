package org.lxp.dailylog.exception;

import static org.lxp.dailylog.exception.CodeEnum.VERIFICATION_CODE_NOT_MATCH;

public class VerificationCodeNotMatchException extends DailylogException {
    private static final long serialVersionUID = 1L;

    public VerificationCodeNotMatchException(String msg) {
        super(VERIFICATION_CODE_NOT_MATCH, msg);
    }
}

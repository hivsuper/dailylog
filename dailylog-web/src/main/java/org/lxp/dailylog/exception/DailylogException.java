package org.lxp.dailylog.exception;

public abstract class DailylogException extends Exception {
    private static final long serialVersionUID = 1L;
    private CodeEnum codeEnum;

    public DailylogException(CodeEnum codeEnum, String msg) {
        super(msg);
        this.codeEnum = codeEnum;
    }

    public CodeEnum getCodeEnum() {
        return codeEnum;
    }
}

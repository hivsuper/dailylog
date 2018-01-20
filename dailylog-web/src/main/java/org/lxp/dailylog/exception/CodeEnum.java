package org.lxp.dailylog.exception;

public enum CodeEnum {
    SUCCESS(200), CREDENTIAL_NOT_MATCH(1), VERIFICATION_CODE_NOT_MATCH(2), PAGE_NOT_FOUND(404), NOT_LOGIN(
            403), INTERNAL_SERVER_ERROR(500);
    private int code;

    private CodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

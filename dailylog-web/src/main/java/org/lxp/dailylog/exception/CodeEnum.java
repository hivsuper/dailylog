package org.lxp.dailylog.exception;

public enum CodeEnum {
    SUCCESS(200, "success"), CREDENTIAL_NOT_MATCH(1, "用户名或密码不正确"), VERIFICATION_CODE_NOT_MATCH(2,
            "验证码错误"), PAGE_NOT_FOUND(404, "页面不存在"), NOT_LOGIN(403, "未登录"), INTERNAL_SERVER_ERROR(500, "服务器内部错误");
    private int code;
    private String message;

    private CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package org.lxp.dailylog.web.util;

import static org.lxp.dailylog.exception.CodeEnum.SUCCESS;

import org.lxp.dailylog.exception.CodeEnum;

public class JsonVo<T> {
    private int code = 0;
    private T content;

    public static final <T> JsonVo<T> success(T content) {
        return new JsonVo<>(SUCCESS, content);
    }

    public JsonVo(CodeEnum codeEnum, T content) {
        this.code = codeEnum.getCode();
        this.content = content;
    }

    public int getCode() {
        return this.code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

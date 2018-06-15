package org.lxp.dailylog.web.util;

import java.io.Serializable;

public class Verify implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;// 如 1 + 2
    private Integer value;// 如 3

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

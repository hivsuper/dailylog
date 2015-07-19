package org.lxp.dailylog.web.util;

import org.lxp.dailylog.exception.DailylogException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Super.Li
 * @since 2015年7月19日
 */
public class JsonVo<T> {
  private int code = 0;
  @JsonInclude(Include.NON_NULL)
  private String msg;
  @JsonInclude(Include.NON_NULL)
  private T content;

  public void setRtn(DailylogException e) {
    if (e == null) {
      throw new IllegalArgumentException("e can't be null.");
    }
    this.code = e.getCode();
    this.msg = e.getMessage();
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return this.msg;
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

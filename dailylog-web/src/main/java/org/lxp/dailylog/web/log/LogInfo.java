package org.lxp.dailylog.web.log;

import java.io.Serializable;

import org.lxp.dailylog.model.User;

public class LogInfo implements Serializable {
  private static final long serialVersionUID = 1L;
  User user;
  String ip;
  String args;
  String aciton;
  String result;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getArgs() {
    return args;
  }

  public void setArgs(String args) {
    this.args = args;
  }

  public String getAciton() {
    return aciton;
  }

  public void setAciton(String aciton) {
    this.aciton = aciton;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}
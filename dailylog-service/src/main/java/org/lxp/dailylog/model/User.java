package org.lxp.dailylog.model;

import java.util.Date;

/**
 * @author super
 * @since 2013-4-22 下午2:43:03
 * @version 1.0
 */
public class User {
  private long id;
  private String username;
  private String password;
  private Date lastlogintime;
  private Date createtime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getLastlogintime() {
    return lastlogintime;
  }

  public void setLastlogintime(Date lastlogintime) {
    this.lastlogintime = lastlogintime;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }
}

package org.lxp.dailylog.model;

import java.util.Date;

/**
 * @author super
 * @since 2013年11月8日上午12:05:47
 * @version 1.0
 */
public class Account {
  private long id;
  /**
   * user logon name
   */
  private String username;
  /**
   * email Address on Account
   */
  private String remail;
  /**
   * forget password email
   */
  private String fpemail;
  /**
   * phone number
   */
  private String phone;
  /**
   * product name
   */
  private String productname;
  /**
   * product url
   */
  private String producturl;
  /**
   * registration date
   */
  private Date joindate;
  /**
   * record creation time
   */
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

  public String getRemail() {
    return remail;
  }

  public void setRemail(String remail) {
    this.remail = remail;
  }

  public String getFpemail() {
    return fpemail;
  }

  public void setFpemail(String fpemail) {
    this.fpemail = fpemail;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }

  public String getProducturl() {
    return producturl;
  }

  public void setProducturl(String producturl) {
    this.producturl = producturl;
  }

  public Date getJoindate() {
    return joindate;
  }

  public void setJoindate(Date joindate) {
    this.joindate = joindate;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

}

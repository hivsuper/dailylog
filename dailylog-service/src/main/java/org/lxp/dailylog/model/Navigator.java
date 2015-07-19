package org.lxp.dailylog.model;

import java.util.Date;

/**
 * @author super
 * @since 2013年11月8日上午12:05:47
 * @version 1.0
 */
public class Navigator {
  private long id;
  /**
   * site name
   */
  private String name;
  /**
   * site link
   */
  private String url;
  /**
   * site title used for a label
   */
  private String title;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

}

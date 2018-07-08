package org.lxp.dailylog.vo;

import org.lxp.dailylog.model.UserBase;

import java.util.Date;

public class UserVo {
    private Long id;

    private String username;

    private Date lastLoginTime;

    private Date createTime;

    public UserVo() {
    }

    public UserVo(UserBase userBase) {
        this.id = userBase.getId();
        this.username = userBase.getUsername();
        this.lastLoginTime = userBase.getLastLoginTime();
        this.createTime = userBase.getCreateTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserVo{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}

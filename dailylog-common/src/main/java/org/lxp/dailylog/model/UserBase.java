package org.lxp.dailylog.model;

import java.util.Date;

public class UserBase {
    private Long seqid;

    private String username;

    private String password;

    private Date lastlogintime;

    private Date createtime;

    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seqid=").append(seqid);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}
package org.lxp.dailylog.vo;

import java.util.Date;

import org.lxp.dailylog.model.UserBase;

public class UserVo {
    private Long seqid;

    private String username;

    private Date lastlogintime;

    private Date createtime;

    public UserVo() {
    }

    public UserVo(UserBase userBase) {
        this.seqid = userBase.getSeqid();
        this.username = userBase.getUsername();
        this.lastlogintime = userBase.getLastlogintime();
        this.createtime = userBase.getCreatetime();
    }

    public Long getSeqid() {
        return seqid;
    }

    public String getUsername() {
        return username;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserVo [seqid=").append(seqid).append(", username=").append(username).append(", lastlogintime=")
                .append(lastlogintime).append(", createtime=").append(createtime).append("]");
        return builder.toString();
    }
}

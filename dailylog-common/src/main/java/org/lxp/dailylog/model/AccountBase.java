package org.lxp.dailylog.model;

import static org.lxp.dailylog.util.DateUtil.TIMEZONE;
import static org.lxp.dailylog.util.DateUtil.yyyyMMddHHmm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class AccountBase {
    private Long seqid;

    @ApiModelProperty(value = "user logon name")
    private String username;

    @ApiModelProperty(value = "email Address on Account")
    private String remail;

    @ApiModelProperty(value = "forget password email")
    private String fpemail;

    @ApiModelProperty(value = "phone number")
    private String phone;

    @ApiModelProperty(value = "product name")
    private String productname;

    @ApiModelProperty(value = "product url")
    private String producturl;

    @ApiModelProperty(value = "registration date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = yyyyMMddHHmm, timezone = TIMEZONE)
    private Date joindate;

    @ApiModelProperty(value = "record creation time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = yyyyMMddHHmm, timezone = TIMEZONE)
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

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail == null ? null : remail.trim();
    }

    public String getFpemail() {
        return fpemail;
    }

    public void setFpemail(String fpemail) {
        this.fpemail = fpemail == null ? null : fpemail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProducturl() {
        return producturl;
    }

    public void setProducturl(String producturl) {
        this.producturl = producturl == null ? null : producturl.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seqid=").append(seqid);
        sb.append(", username=").append(username);
        sb.append(", remail=").append(remail);
        sb.append(", fpemail=").append(fpemail);
        sb.append(", phone=").append(phone);
        sb.append(", productname=").append(productname);
        sb.append(", producturl=").append(producturl);
        sb.append(", joindate=").append(joindate);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}
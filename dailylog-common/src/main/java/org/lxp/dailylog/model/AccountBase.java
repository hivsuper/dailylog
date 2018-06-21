package org.lxp.dailylog.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

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
    private Date joindate;

    @ApiModelProperty(value = "record creation time")
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
        StringBuilder builder = new StringBuilder();
        builder.append("AccountBase [seqid=").append(seqid).append(", username=").append(username).append(", remail=")
                .append(remail).append(", fpemail=").append(fpemail).append(", phone=").append(phone)
                .append(", productname=").append(productname).append(", producturl=").append(producturl)
                .append(", joindate=").append(joindate).append(", createtime=").append(createtime).append("]");
        return builder.toString();
    }
}
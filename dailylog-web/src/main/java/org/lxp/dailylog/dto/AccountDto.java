package org.lxp.dailylog.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;

public class AccountDto {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joindate;

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

    @Override
    public String toString() {
        return String.format(
                "AccountDto [username=%s, remail=%s, fpemail=%s, phone=%s, productname=%s, producturl=%s, joindate=%s]",
                username, remail, fpemail, phone, productname, producturl, joindate);
    }
}
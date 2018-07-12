package org.lxp.dailylog.model;

import java.util.Date;

import org.lxp.dailylog.util.DateUtil;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class AccountBase {
    private Long id;

    @ApiModelProperty(value = "user logon name")
    private String username;

    @ApiModelProperty(value = "email Address of the Account")
    private String email;

    @ApiModelProperty(value = "forget password email")
    private String forgetPasswordEmail;

    @ApiModelProperty(value = "phone number")
    private String phone;

    @ApiModelProperty(value = "product name")
    private String productName;

    @ApiModelProperty(value = "product url")
    private String productUrl;

    @ApiModelProperty(value = "registration date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.yyyyMMdd, timezone = DateUtil.TIMEZONE)
    private Date joinDate;

    private Boolean isActive;

    @ApiModelProperty(value = "record creation time")
    private Date createTime;

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
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getForgetPasswordEmail() {
        return forgetPasswordEmail;
    }

    public void setForgetPasswordEmail(String forgetPasswordEmail) {
        this.forgetPasswordEmail = forgetPasswordEmail == null ? null : forgetPasswordEmail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl == null ? null : productUrl.trim();
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", forgetPasswordEmail=").append(forgetPasswordEmail);
        sb.append(", phone=").append(phone);
        sb.append(", productName=").append(productName);
        sb.append(", productUrl=").append(productUrl);
        sb.append(", joinDate=").append(joinDate);
        sb.append(", isActive=").append(isActive);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}
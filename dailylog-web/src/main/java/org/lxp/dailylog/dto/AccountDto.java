package org.lxp.dailylog.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AccountDto {
    @ApiModelProperty(value = "user logon name", required = true)
    private String username;

    @ApiModelProperty(value = "email Address of the Account", required = true)
    private String email;

    @ApiModelProperty(value = "forget password email")
    private String forgetPasswordEmail;

    @ApiModelProperty(value = "phone number")
    private String phone;

    @ApiModelProperty(value = "product name")
    private String productName;

    @ApiModelProperty(value = "product url", required = true)
    private String productUrl;

    @ApiModelProperty(value = "registration date", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getForgetPasswordEmail() {
        return forgetPasswordEmail;
    }

    public void setForgetPasswordEmail(String forgetPasswordEmail) {
        this.forgetPasswordEmail = forgetPasswordEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", forgetPasswordEmail='").append(forgetPasswordEmail).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productUrl='").append(productUrl).append('\'');
        sb.append(", joinDate=").append(joinDate);
        sb.append('}');
        return sb.toString();
    }
}
package org.lxp.dailylog.model;

import java.util.Date;

public class UserBase {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.seqId
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    private Long seqid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.lastlogintime
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    private Date lastlogintime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.createtime
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.seqId
     *
     * @return the value of user.seqId
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public Long getSeqid() {
        return seqid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.seqId
     *
     * @param seqid the value for user.seqId
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.lastlogintime
     *
     * @return the value of user.lastlogintime
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.lastlogintime
     *
     * @param lastlogintime the value for user.lastlogintime
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.createtime
     *
     * @return the value of user.createtime
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.createtime
     *
     * @param createtime the value for user.createtime
     *
     * @mbggenerated Sun Jul 19 19:39:54 GMT+08:00 2015
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
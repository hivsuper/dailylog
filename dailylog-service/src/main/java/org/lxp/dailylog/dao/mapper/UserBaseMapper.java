package org.lxp.dailylog.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.model.UserBaseExample;

public interface UserBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int countByExample(UserBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int deleteByExample(UserBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int deleteByPrimaryKey(Long seqid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int insert(UserBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int insertSelective(UserBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    List<UserBase> selectByExample(UserBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    UserBase selectByPrimaryKey(Long seqid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int updateByExampleSelective(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int updateByExample(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int updateByPrimaryKeySelective(UserBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Jul 21 01:51:14 GMT+08:00 2015
     */
    int updateByPrimaryKey(UserBase record);
}
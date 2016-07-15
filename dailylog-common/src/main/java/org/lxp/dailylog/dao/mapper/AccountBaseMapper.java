package org.lxp.dailylog.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.model.AccountBaseExample;

public interface AccountBaseMapper {
    int countByExample(AccountBaseExample example);

    int deleteByExample(AccountBaseExample example);

    int deleteByPrimaryKey(Long seqid);

    int insert(AccountBase record);

    int insertSelective(AccountBase record);

    List<AccountBase> selectByExample(AccountBaseExample example);

    AccountBase selectByPrimaryKey(Long seqid);

    int updateByExampleSelective(@Param("record") AccountBase record, @Param("example") AccountBaseExample example);

    int updateByExample(@Param("record") AccountBase record, @Param("example") AccountBaseExample example);

    int updateByPrimaryKeySelective(AccountBase record);

    int updateByPrimaryKey(AccountBase record);
}
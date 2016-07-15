package org.lxp.dailylog.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lxp.dailylog.model.NavigatorBase;
import org.lxp.dailylog.model.NavigatorBaseExample;

public interface NavigatorBaseMapper {
    int countByExample(NavigatorBaseExample example);

    int deleteByExample(NavigatorBaseExample example);

    int deleteByPrimaryKey(Long seqid);

    int insert(NavigatorBase record);

    int insertSelective(NavigatorBase record);

    List<NavigatorBase> selectByExample(NavigatorBaseExample example);

    NavigatorBase selectByPrimaryKey(Long seqid);

    int updateByExampleSelective(@Param("record") NavigatorBase record, @Param("example") NavigatorBaseExample example);

    int updateByExample(@Param("record") NavigatorBase record, @Param("example") NavigatorBaseExample example);

    int updateByPrimaryKeySelective(NavigatorBase record);

    int updateByPrimaryKey(NavigatorBase record);
}
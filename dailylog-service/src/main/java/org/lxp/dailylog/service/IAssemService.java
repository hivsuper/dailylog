package org.lxp.dailylog.service;

/**
 * 该接口主要提供在查询数据列表时需要对每个数据进行特殊处理的功能. 该接口只在BaseDao 中的query方法中被使用到。
 * 
 * @see org.lxp.dailylog.service.dao.BaseDao
 * 
 */
public interface IAssemService<T> {
  public void hold(T obj);
}

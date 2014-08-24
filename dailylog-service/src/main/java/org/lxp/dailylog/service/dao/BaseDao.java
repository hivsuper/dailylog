package org.lxp.dailylog.service.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.lxp.dailylog.service.IAssemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 持久层封装方法
 * 
 * @author super
 * @since 2012-10-25 下午2:27:46
 * @version 1.0
 */
public abstract class BaseDao<T> extends JdbcDaoSupport {
  private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
  @Autowired
  public DataSource dataSource;

  /**
   * 查询单个整数
   * 
   * @param sql
   *          查询语句
   * @return
   */
  public int getSingleInt(final String sql) {
    int result = 0;
    try {
      logger.debug("get int sql:" + sql);
      Integer i = getJdbcTemplate().queryForObject(sql, Integer.class);
      result = i == null ? 0 : i.intValue();
    } catch (DataAccessException e) {
      result = 0;
    }
    return result;
  }

  /**
   * 查询单个整数
   * 
   * @param sql
   *          查询语句
   * @param params
   *          参数列表数组
   * @return
   */
  public int getSingleIntWithKeyHolder(final String sql, final Object[] params) {
    int result = 0;
    try {
      logger.debug("get int sql:" + sql + " params:" + Arrays.toString(params));
      Integer i = getJdbcTemplate().queryForObject(sql, Integer.class, params);
      result = i == null ? 0 : i.intValue();
    } catch (DataAccessException e) {
      result = 0;
    }
    return result;
  }

  /**
   * 查询单个double数
   * 
   * @param sql
   *          查询语句
   * @return
   */
  public double getSingleDouble(final String sql) {
    double result = 0.0;
    try {
      logger.debug("get double sql:" + sql);
      Double d = getJdbcTemplate().queryForObject(sql, Double.class);
      result = d == null ? 0D : d.doubleValue();
    } catch (DataAccessException e) {
      result = 0.0;
    }
    return result;
  }

  /**
   * 查询单个double数
   * 
   * @param sql
   *          查询语句
   * @param params
   *          参数列表数组
   * @return
   */
  public double getSingleDoubleWithKeyHolder(final String sql, final Object[] params) {
    double result = 0.0;
    try {
      logger.debug("get double sql:" + sql + " params:" + Arrays.toString(params));
      Double d = getJdbcTemplate().queryForObject(sql, Double.class, params);
      result = d == null ? 0D : d.doubleValue();
    } catch (DataAccessException e) {
      result = 0.0;
    }
    return result;
  }

  /**
   * 带有占位符的语句执行
   * 
   * @param sql
   *          需要执行的语句
   * @return 返回受影响的行数
   */
  public int excuteSql(final String sql) {
    logger.debug("excute sql:" + sql);
    return getJdbcTemplate().update(sql);
  }

  /**
   * 带有占位符的语句执行
   * 
   * @param sql
   *          需要执行的语句
   * @param params
   *          参数列表数组
   * @return 返回受影响的行数
   */
  public int excuteSqlWithKeyHolder(final String sql, final Object[] params) {
    logger.debug("excute sql:" + sql + " params:" + Arrays.toString(params));
    return getJdbcTemplate().update(sql, params);
  }

  /**
   * 返回符合某一sql语句的第一条记录，使用占位符
   * 
   * @param clazz
   *          指定的VO类
   * @param sql
   *          sql语句
   * @param params
   *          参数列表数组
   * @return
   */
  public T queryOneWithKeyHolder(final Class<T> clazz, final String sql, final Object[] params) {
    return queryOneWithKeyHolder(clazz, sql, params, null);
  }

  /**
   * 返回符合某一sql语句的第一条记录，使用占位符
   * 
   * @param clazz
   *          指定的VO类
   * @param sql
   *          sql语句
   * @param params
   *          参数列表数组
   * @param assemService
   *          特殊处理方法
   * @return
   */
  public T queryOneWithKeyHolder(final Class<T> clazz, final String sql, final Object[] params,
      final IAssemService<T> assemService) {
    List<T> list = queryWithKeyHolder(clazz, sql, params, assemService);
    return (list.size() < 1) ? null : list.get(0);
  }

  /**
   * 返回符合某一sql语句的第一条记录，使用占位符
   * 
   * @param clazz
   *          指定的VO类
   * @param sql
   *          sql语句
   * @param params
   *          参数列表数组
   * @param assemService
   *          特殊处理方法
   * @param excludeFields
   *          不需要的字段
   * @param includeFields
   *          需要的字段
   * @return
   */
  public T queryOneWithKeyHolder(final Class<T> clazz, final String sql, final Object[] params,
      final IAssemService<T> assemService, final String[] excludeFields, final String[] includeFields) {
    List<T> list = queryWithKeyHolder(clazz, sql, params, assemService, excludeFields, includeFields);
    return (list.size() < 1) ? null : list.get(0);
  }

  /**
   * 返回符合某一sql语句的记录，使用占位符
   * 
   * @param clazz
   *          指定的VO类
   * @param sql
   *          sql语句
   * @param params
   *          参数列表数组
   * @return
   */
  public List<T> queryWithKeyHolder(final Class<T> clazz, final String sql, final Object[] params) {
    return queryWithKeyHolder(clazz, sql, params, null);
  }

  /**
   * 返回符合某一sql语句的记录，使用占位符
   * 
   * @param clazz
   *          指定的VO类
   * @param sql
   *          sql语句
   * @param params
   *          参数列表数组
   * @param assemService
   *          特殊处理方法
   * @return
   */
  public List<T> queryWithKeyHolder(final Class<T> clazz, final String sql, final Object[] params,
      final IAssemService<T> assemService) {
    return queryWithKeyHolder(clazz, sql, params, assemService, null, null);
  }

  /**
   * 返回符合某一sql语句的记录，使用占位符
   * 
   * @param clazz
   *          指定的VO类
   * @param sql
   *          sql语句
   * @param params
   *          参数列表数组
   * @param assemService
   *          特殊处理方法
   * @param excludeFields
   *          不需要的字段
   * @param includeFields
   *          需要的字段
   * @return
   */
  public List<T> queryWithKeyHolder(final Class<T> clazz, final String sql, final Object[] params,
      final IAssemService<T> assemService, final String[] excludeFields, final String[] includeFields) {
    final List<T> datas = new ArrayList<T>();
    StringBuffer param = new StringBuffer();
    if (params instanceof Object[])
      param.append("params:" + Arrays.toString(params));
    logger.debug("query sql:" + sql + param.toString());
    getJdbcTemplate().query(sql, params, new RowCallbackHandler() {
      public void processRow(ResultSet rs) throws SQLException {
        T indata;
        String fname = "";
        Method method = null;
        try {
          indata = (T) clazz.newInstance();
          for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
              continue;
            }
            fname = field.getName();
            method = clazz.getDeclaredMethod("set" + capitalize(fname), field.getType());
            if (field.getType() == Boolean.TYPE || field.getType() == Boolean.class) {
              method.invoke(indata, rs.getBoolean(fname));
            } else if (field.getType() == Byte.TYPE || field.getType() == Byte.class) {
              method.invoke(indata, rs.getByte(fname));
            } else if (field.getType() == Short.TYPE || field.getType() == Short.class) {
              method.invoke(indata, rs.getShort(fname));
            } else if (field.getType() == Integer.TYPE || field.getType() == Integer.class) {
              method.invoke(indata, rs.getInt(fname));
            } else if (field.getType() == Long.TYPE || field.getType() == Long.class) {
              method.invoke(indata, rs.getLong(fname));
            } else if (field.getType() == Float.TYPE || field.getType() == Float.class) {
              method.invoke(indata, rs.getFloat(fname));
            } else if (field.getType() == Double.TYPE || field.getType() == Double.class) {
              method.invoke(indata, rs.getDouble(fname));
            } else if (field.getType() == Date.class) {
              if (rs.getObject(fname) == null) {
                method.invoke(indata, new Object[] { null });
              } else {
                method.invoke(indata, new Date(rs.getDate(fname).getTime()));
              }
            } else if (field.getType() == java.sql.Date.class) {
              if (rs.getObject(fname) == null) {
                method.invoke(indata, new Object[] { null });
              } else {
                method.invoke(indata, new java.sql.Date(rs.getDate(fname).getTime()));
              }
            } else {
              method.invoke(indata, rs.getString(fname));
            }
          }
          if (assemService != null) {
            assemService.hold(indata);
          }
          datas.add(indata);
        } catch (Exception ex) {
          throw new RuntimeException("query list error (field: " + fname + ").", ex);
        }
      }
    });
    return datas;
  }

  /**
   * 把name首字母替换为大写
   * 
   * @param name
   *          方法名
   * @return
   */
  private static String capitalize(String name) {
    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }

  /**
   * 注入dataSource，由于不能直接覆盖注入方法
   */
  @Resource(name = "dataSource")
  public void setDataS(DataSource dataSource) {
    this.setDataSource(dataSource);
  }
}

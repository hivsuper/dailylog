package org.lxp.dailylog.service.util;

/**
 * @author super
 * @since 2013-1-4 下午2:20:50
 * @version 1.0
 */
public class ConvertSqlUtil {
  /**
   * 需要进行过滤并替换的sql字符
   */
  private static final String[][] sqlhandles = { { "\\\\", "\\\\\\\\" }, { "_", "\\\\_" }, { "%", "\\\\%" } };

  /**
   * 将字符串中包含有mysql通配符转义
   * 
   * @param str
   *          需要进行过滤的字符串
   * @return 过滤后的安全字符串
   */
  public static final String convertSql(String str) {
    if (str == null) {
      return "";
    }
    for (String[] ss : sqlhandles) {
      str = str.replaceAll(ss[0], ss[1]);
    }
    return str;
  }

  /**
   * 测试主方法
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(convertSql("_"));
  }
}

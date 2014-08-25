package org.lxp.dailylog.web.log;

import java.util.Map;
import java.util.Set;

public class LogUtil {
  public static String getMsgLog(LogInfo loginfo) {
    String msg = "";
    if (null != loginfo.getUser())
      msg = msg + "USER:" + loginfo.getUser().getUsername();
    else
      msg = "USER:" + "NULL";
    msg = msg + " IP:" + loginfo.getIp();
    msg = msg + " URL:" + loginfo.getAciton();
    msg = msg + " ARGS:" + loginfo.getArgs();
    msg = msg + " RESULT:" + loginfo.getResult();
    return msg;
  }

  /**
   * 设置日志信息中的参数
   * 
   * @param dmsLog
   * @param paraMap
   */
  public static LogInfo setArgsLog(LogInfo loginfo, Map<String, String[]> paraMap) {
    String para = "";
    Set<String> paraKey = paraMap.keySet();
    for (String key : paraKey) {
      Object[] arr = (Object[]) paraMap.get(key);
      for (Object val : arr) {
        val = key.contains("password") || key.contains("passwd") ? "" : val;
        para = para + key + "=" + val + ";";
      }
    }
    loginfo.setArgs(para);
    return loginfo;
  }
}

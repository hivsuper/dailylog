package org.lxp.dailylog.service.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

/**
 * @author super
 * @version 23 Feb 2012
 */
public class CiphertextUtil {

  private static final String splitString = StringHolder.SPLIT_STRING;

  /**
   * 解密信息
   * 
   * @param value
   * @return
   */
  public static String[] decode(String value) {
    StringBuilder sb = new StringBuilder(value.length() + 3).append(value);
    for (int j = 0; j < sb.length() % 4; j++) {// 解开密码的salt，把去掉的=加上去
      sb.append("=");
    }
    value = sb.toString();
    String cookieAsPlainText = new String(Base64.decodeBase64(value.getBytes()));
    return StringUtils.delimitedListToStringArray(cookieAsPlainText, splitString);
  }

  /**
   * 加密信息
   * 
   * @param tokens
   * @return
   */
  public static String encode(String[] tokens) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      sb.append(tokens[i]);
      if (i < tokens.length - 1) {
        sb.append(splitString);
      }
    }
    String value = sb.toString();
    sb = new StringBuilder(new String(Base64.encodeBase64(value.getBytes())));
    while (sb.charAt(sb.length() - 1) == '=') {// 为密码加salt，去掉密文最后的=
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }

}

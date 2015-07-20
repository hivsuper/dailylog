package org.lxp.dailylog.util;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
import static org.springframework.util.StringUtils.delimitedListToStringArray;

/**
 * @author super
 * @version 23 Feb 2012
 */
public class CiphertextUtil {

  private static final String SEPARATOR = ";";
  private static final String SALT = "lee";

  public static String[] decode(String token) {
    StringBuilder sb = new StringBuilder(token.length() + 3).append(token);
    for (int j = 0; j < sb.length() % 4; j++) {
      sb.append("=");
    }
    token = sb.toString();
    String cookieAsPlainText = new String(decodeBase64(token.getBytes()));
    return delimitedListToStringArray(cookieAsPlainText, SEPARATOR);
  }

  public static String encode(String value) {
    StringBuilder sb = new StringBuilder();
    sb.append(value).append(SEPARATOR).append(SALT);
    value = sb.toString();
    sb = new StringBuilder(new String(encodeBase64(value.getBytes())));
    while (sb.charAt(sb.length() - 1) == '=') {
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }

}
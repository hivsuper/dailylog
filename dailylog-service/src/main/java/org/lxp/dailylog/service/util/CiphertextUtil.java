package org.lxp.dailylog.service.util;

import static org.lxp.dailylog.service.util.StringHolder.SEMICOLON;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

/**
 * @author super
 * @version 23 Feb 2012
 */
public class CiphertextUtil {

  private static final String SEPARATOR = SEMICOLON;

  public static String[] decode(String value) {
    StringBuilder sb = new StringBuilder(value.length() + 3).append(value);
    for (int j = 0; j < sb.length() % 4; j++) {
      sb.append("=");
    }
    value = sb.toString();
    String cookieAsPlainText = new String(Base64.decodeBase64(value.getBytes()));
    return StringUtils.delimitedListToStringArray(cookieAsPlainText, SEPARATOR);
  }

  public static String encode(String[] tokens) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      sb.append(tokens[i]);
      if (i < tokens.length - 1) {
        sb.append(SEPARATOR);
      }
    }
    String value = sb.toString();
    sb = new StringBuilder(new String(Base64.encodeBase64(value.getBytes())));
    while (sb.charAt(sb.length() - 1) == '=') {
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }

}

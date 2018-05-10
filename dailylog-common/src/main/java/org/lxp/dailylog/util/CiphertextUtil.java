package org.lxp.dailylog.util;

import static org.springframework.util.StringUtils.delimitedListToStringArray;

import java.util.Base64;

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
        String cookieAsPlainText = new String(Base64.getDecoder().decode(token.getBytes()));
        return delimitedListToStringArray(cookieAsPlainText, SEPARATOR);
    }

    public static String encode(String value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value).append(SEPARATOR).append(SALT);
        value = sb.toString();
        sb = new StringBuilder(Base64.getEncoder().encodeToString(value.getBytes()));
        while (sb.charAt(sb.length() - 1) == '=') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
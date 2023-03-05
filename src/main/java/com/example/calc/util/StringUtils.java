package com.example.calc.util;

import sun.security.x509.IssuingDistributionPointExtension;

/**
 * @author lishengbing
 * @version 1.0
 * @date 2023-03-03 22:55:27
 * @description
 * @since JDK 1.8
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * 字符串是否为空
     */
    public static boolean isEmpty(String ori) {
        if (ori == null) {
            return true;
        }
        return ori.equals(StrConst.EMPTY);
    }

    /**
     * 判断字符串是否为数字
     */
    public static boolean isNumber(String ori) {
        //是否包含小数点
        int dotIndex = ori.indexOf(StrConst.DOT);
        if (dotIndex > 0) {
            String left = ori.substring(0, dotIndex);
            String right = ori.substring(dotIndex + 1);
            return isDigit(left) && isDigit(right);
        }
        return isDigit(ori);
    }

    private static boolean isDigit(String ori) {
        if (isEmpty(ori)) {
            return false;
        }
        for (int i = 0, len = ori.length(); i < len; i++) {
            char c = ori.charAt(i);
            // 这里不考虑 +123 这种数字前面加上 + 或者 - 的情况
            /*if (c == '+' || c == '-') {
             *  continue;
            }*/
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

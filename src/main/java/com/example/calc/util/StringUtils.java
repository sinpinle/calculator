package com.example.calc.util;

import com.example.calc.StrConst;

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

    public static boolean isEmpty(String ori) {
        if (ori == null) {
            return true;
        }
        return ori.equals(StrConst.EMPTY);
    }
}

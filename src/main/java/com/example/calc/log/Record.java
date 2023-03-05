package com.example.calc.log;

import com.example.calc.util.StrConst;
import com.example.calc.util.StringUtils;

/**
 * @author lishengbing
 * @version 1.0
 * @date 2023-03-03 22:40:32
 * @description
 * @since JDK 1.8
 */
public final class Record {

    private final String expression;

    private final String result;

    private final String errMsg;

    private Record(String expression, String result, String errMsg) {
        this.expression = expression;
        this.result = result;
        this.errMsg = errMsg;
    }

    public static Record ok(String expression, String result) {
        return new Record(expression, result, null);
    }

    public static Record fail(String errMsg) {
        return new Record(null, null, errMsg);
    }

    public boolean isError() {
        return !StringUtils.isEmpty(this.errMsg);
    }

    @Override
    public String toString() {
        if (isError()) {
            return errMsg;
        }
        return expression + StrConst.EQUALS + result;
    }
}

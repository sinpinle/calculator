package com.example.calc.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 精度问题，暂且最多保留12位小数
 *
 * @author lishengbing
 * @version 1.0
 * @date 2023-03-04 12:47:34
 * @description 计算工具类
 * @since JDK 1.8
 */
public final class CalcUtils {

    private CalcUtils() {
    }

    /**
     * 计算结果
     */
    public static String calculate(String[] inputs) {
        String opr = inputs[1];
        BigDecimal first = new BigDecimal(inputs[0]);
        BigDecimal second = new BigDecimal(inputs[2]);
        switch (opr) {
            case StrConst.ADD:
                return add(first, second);
            case StrConst.DIVIDE:
                return divide(first, second);
            case StrConst.SUBTRACT:
                return subtract(first, second);
            case StrConst.MULTIPLY:
                return multiply(first, second);
            default:
                throw new UnsupportedOperationException("不支持此运算操作 [" + opr + "]");
        }

    }

    private static String multiply(BigDecimal first, BigDecimal second) {
        BigDecimal result = first.multiply(second);
        return result.toPlainString();
    }

    private static String subtract(BigDecimal first, BigDecimal second) {
        BigDecimal result = first.subtract(second);
        return result.toPlainString();
    }

    private static String divide(BigDecimal first, BigDecimal second) {
        if (second.signum() == 0) {
            throw new IllegalArgumentException("除数为0");
//            return "NaN";
        }
        BigDecimal result = first.divide(second, 12, RoundingMode.HALF_UP).stripTrailingZeros();
        return result.toPlainString();
    }

    private static String add(BigDecimal first, BigDecimal second) {
        BigDecimal result = first.add(second);
        return result.toPlainString();
    }

}

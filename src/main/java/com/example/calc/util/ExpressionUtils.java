package com.example.calc.util;

import java.util.regex.Pattern;

/**
 * @author lishengbing
 * @version 1.0
 * @date 2023-03-03 22:59:23
 * @description
 * @since JDK 1.8
 */
public final class ExpressionUtils {

    private static final String OPERATOR = "[+\\-*/]";

    private static final Pattern NUM_REG = Pattern.compile("[-|+]?\\d+(.\\d+)?");

    private ExpressionUtils() {
    }

    /**
     * 判断运算表达式是否合法
     *
     * @param expression 运算表达式
     * @return boolean
     */
    public static boolean validExpression(String expression) {
        return NUM_REG.matcher(expression).matches();
    }

    /**
     * 分割输入的表达式
     * 只针对简单的运算表达式，不包含括号等
     * 这里不支持复杂的运算表达式
     *
     * @param expression 运算表达式
     * @return str[0] 数字；str[1] 运算符；str[2] 数字
     */
    public static String[] splitExpression(String expression) {
        //前提是合法的运算表达式，应用类已经调用 validExpression 方法
        return expression.split(OPERATOR);
    }

}

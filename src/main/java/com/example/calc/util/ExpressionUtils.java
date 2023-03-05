package com.example.calc.util;

/**
 * @author lishengbing
 * @version 1.0
 * @date 2023-03-03 22:59:23
 * @description
 * @since JDK 1.8
 */
public final class ExpressionUtils {

    private ExpressionUtils() {
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
        String opr;
        int oprIndex;
        if (expression.contains(StrConst.ADD)) {
            opr = StrConst.ADD;
            oprIndex = expression.indexOf(StrConst.ADD, 1);
        } else if (expression.contains(StrConst.SUBTRACT)) {
            opr = StrConst.SUBTRACT;
            oprIndex = expression.indexOf(StrConst.SUBTRACT, 1);
        } else if (expression.contains(StrConst.MULTIPLY)) {
            opr = StrConst.MULTIPLY;
            oprIndex = expression.indexOf(StrConst.MULTIPLY);
        } else if (expression.contains(StrConst.DIVIDE)) {
            opr = StrConst.DIVIDE;
            oprIndex = expression.indexOf(StrConst.DIVIDE);
        } else {
            throw new IllegalArgumentException("运算表达式错误，请重新输入");
        }

        if (oprIndex < 1) {
            throw new IllegalArgumentException("运算表达式错误，请重新输入");
        }

        String first = expression.substring(0, oprIndex);
        String second = expression.substring(oprIndex + 1);

        //校验字符串是否是合法的数字
        if (!StringUtils.isNumber(first) || !StringUtils.isNumber(second)) {
            throw new IllegalArgumentException("运算表达式错误，请重新输入");
        }

        return new String[]{first, opr, second};
    }


}

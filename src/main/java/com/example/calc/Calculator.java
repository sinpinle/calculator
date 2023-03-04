package com.example.calc;

import com.example.calc.log.CalcLogger;
import com.example.calc.log.Record;
import com.example.calc.util.CalcUtils;
import com.example.calc.util.ExpressionUtils;
import com.example.calc.util.StringUtils;

/**
 * 只是简单的两个数字的加减乘除
 * 不考虑复杂的场景
 * 运算表达式也有要求  e.g.  123.45+567.89
 *
 * @author lishengbing
 * @version 1.0
 * @date 2023-03-03 22:37:34
 * @description
 * @since JDK 1.8
 */
public class Calculator {

    /**
     * 记录历史
     */
    private final CalcLogger calcLogger;

    public Calculator(int recordsNum) {
        this.calcLogger = new CalcLogger(recordsNum);
    }

    /**
     * 计算器计算处理
     *
     * @param expression 运算表达式
     * @return 计算结果，以 {@linkplain  Record} 返回
     */
    public Record calc(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return Record.fail("请输入运算表达式");
        }
        boolean valid = ExpressionUtils.validExpression(expression);
        if (!valid) {
            return Record.fail("输入的运算表达式不正确，请重新输入");
        }

        String[] inputs = ExpressionUtils.splitExpression(expression);
        String calcResult;
        try {
            calcResult = CalcUtils.calculate(inputs);
        } catch (Exception e) {
            return Record.fail(e.getMessage());
        }
        Record record = Record.ok(expression, calcResult);
        calcLogger.addRecord(record);
        return record;
    }

    /**
     * 获取上一次的计算记录
     *
     * @return Record
     */
    public Record redo() {
        return calcLogger.getLastRecord();
    }

    /**
     * undo
     */
    public Record undo() {
        // TODO undo 的具体形式是什么
        // TODO 如果先 redo 了，再 undo 是什么样形式
        calcLogger.rmLastLog();
        return Record.fail("请输入运算表达式");
    }

}

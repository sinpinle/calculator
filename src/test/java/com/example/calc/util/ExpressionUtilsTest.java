package com.example.calc.util;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionUtilsTest {

    @Test
    public void valid1() {
        validNumber("+2.3336");
    }

    @Test
    public void valid2() {
        validNumber("-2.3336");
    }

    @Test
    public void valid3() {
        validNumber("-2.3.336");
    }

    @Test
    public void valid4() {
        validNumber("-2.3336s");
    }

    @Test
    public void valid5() {
        validNumber("2.");
    }
    @Test
    public void valid6() {
        validNumber("2");
    }



    private void validNumber(String num) {
        boolean r = ExpressionUtils.validExpression(num);
        consoleLog(num, r);
        if (r) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }

    private void consoleLog(String num, boolean r) {
        String msg = r ? " 是合法数字" : " 非合法数字";
        System.err.println(num + msg);
    }
}
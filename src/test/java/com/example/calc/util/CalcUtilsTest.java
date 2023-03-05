package com.example.calc.util;

import org.junit.Test;

public class CalcUtilsTest {

    @Test
    public void calculate() {
        System.out.println(CalcUtils.calculate(new String[]{"1.20", "*", "0.3"}));
        System.out.println(CalcUtils.calculate(new String[]{"1.28", "+", "0.02"}));
        System.out.println(CalcUtils.calculate(new String[]{"1.28", "-", "2.02"}));
        System.out.println(CalcUtils.calculate(new String[]{"1.28", "/", "2.02"}));
    }
}
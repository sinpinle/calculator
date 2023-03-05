package com.example.calc.util;

import org.junit.Test;

import java.util.function.Consumer;

public class ExpressionUtilsTest {

    @Test
    public void splitExpression() {
        printArray(ExpressionUtils.splitExpression("1.2*1.2"));
        printArray(ExpressionUtils.splitExpression("1.2*10"));
        printArray(ExpressionUtils.splitExpression("1.2+1.2"));
        printArray(ExpressionUtils.splitExpression("1.2/1.2"));
        printArray(ExpressionUtils.splitExpression("1.2-1.2"));
        System.out.println("\n");

        invalidPrint(ExpressionUtils::splitExpression, "1.2- 1.2");
        invalidPrint(ExpressionUtils::splitExpression, "1.2- s1.2");
        invalidPrint(ExpressionUtils::splitExpression, "1.2s1.2");
        invalidPrint(ExpressionUtils::splitExpression, "1.2");
    }

    private void printArray(String[] arr) {
        String join = String.join(",", arr);
        System.out.println(join);
    }

    private void invalidPrint(Consumer<String> consumer, String s) {
        try {
            consumer.accept(s);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
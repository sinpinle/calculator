package com.example.calc.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void isEmpty() {
        String t1 = "";
        System.out.println(StringUtils.isEmpty(t1));
        Assert.assertTrue(StringUtils.isEmpty(t1));//true
        String t2 = null;
        System.out.println(StringUtils.isEmpty(t2));
        Assert.assertTrue(StringUtils.isEmpty(t2));//true
        String t3 = " ";
        System.out.println(StringUtils.isEmpty(t3));
        Assert.assertFalse(StringUtils.isEmpty(t3));//false
        String t4 = "1.2*3";
        System.out.println(StringUtils.isEmpty(t4));
        Assert.assertFalse(StringUtils.isEmpty(t4));//false
    }

    @Test
    public void isNumber() {
        String s1 = "1.3334";
        System.out.println(StringUtils.isNumber(s1));
        String s2 = "10.3330";
        System.out.println(StringUtils.isNumber(s2));
        String s3 = "10.";
        System.out.println(StringUtils.isNumber(s3));
        String s4 = "10.0-1";
        System.out.println(StringUtils.isNumber(s4));
        String s5 = "10";
        System.out.println(StringUtils.isNumber(s5));
        String s6 = "0";
        System.out.println(StringUtils.isNumber(s6));

    }
}
package com.example.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void init() {
        calc = new Calculator(1);

    }

    @Test
    public void calc() {
        System.out.println(calc.calc("3*4"));
        System.out.println(calc.calc("3*/3"));
        System.out.println(calc.calc("1/3"));
        System.out.println(calc.calc("1/0"));
        System.out.println(calc.calc("1.2/3"));

        System.out.println(calc.redo());
        System.out.println(calc.redo());
        System.out.println(calc.undo());
        System.out.println(calc.redo());
    }

    @Test
    @After
    public void redo() {
    }

    @Test
    public void undo() {
    }
}
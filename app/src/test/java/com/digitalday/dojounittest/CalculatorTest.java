package com.digitalday.dojounittest;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by athila on 20/06/15.
 */
public class CalculatorTest {

    private static Calculator mCalculator;

    @BeforeClass
    public static void setUpCalculator() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(6, mCalculator.sum(1, 5), 0);
    }

    @Test
    public void testSubstract() throws Exception {
        assertEquals(1, mCalculator.substract(5, 4), 0);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(4, mCalculator.divide(20, 5), 0);
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(10, mCalculator.multiply(2, 5), 0);
    }
}
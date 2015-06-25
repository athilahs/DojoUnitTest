package com.digitalday.dojounittest;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by athila on 20/06/15.
 */
public class CalculatorTest {

    private static Calculator mCalculator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUpCalculator() {
        mCalculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals(6, mCalculator.sum(1, 5), 0);
    }

    @Test
    public void testSumThreeDigits() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.sum(12, 444);
    }

    @Test
    public void testSumThreeDigitsNegative() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.sum(-123, 44);
    }

    @Test
    public void testSubstract() {
        assertEquals(1, mCalculator.substract(5, 4), 0);
    }

    @Test
    public void testSubstractThreeDigits() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.substract(12, 444);
    }

    @Test
    public void testSubstractThreeDigitsNegative() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.substract(-123, 44);
    }

    @Test
    public void testDivide() {
        assertEquals(4, mCalculator.divide(20, 5), 0);
    }

    @Test
    public void testDivideThreeDigits() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.divide(12, 444);
    }

    @Test
    public void testDivideThreeDigitsNegative() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.divide(-123, 44);
    }

    @Test
    public void testMultiply() {
        assertEquals(10, mCalculator.multiply(2, 5), 0);
    }

    @Test
    public void testMultiplyThreeDigits() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.multiply(12, 444);
    }

    @Test
    public void testMultiplyThreeDigitsNegative() {
        exception.expect(IllegalArgumentException.class);
        mCalculator.multiply(-123, 44);
    }
}
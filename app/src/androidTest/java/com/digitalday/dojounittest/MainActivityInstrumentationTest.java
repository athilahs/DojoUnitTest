package com.digitalday.dojounittest;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by athila on 20/06/15.
 */
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSum() {

        int op1 = 32;
        int op2 = 21;

        onView(withId(R.id.sumOp1)).perform(typeText(Integer.toString(op1)));
        onView(withId(R.id.sumOp2)).perform(typeText(Integer.toString(op2)), closeSoftKeyboard());

        int expected = op1 + op2;

        onView(withId(R.id.sumTotal)).check(matches(withText(Integer.toString(expected))));
    }

    @Test
    public void testSubtract() {

        int op1 = 75;
        int op2 = 49;

        onView(withId(R.id.subtractOp1)).perform(typeText(Integer.toString(op1)));
        onView(withId(R.id.subtractOp1)).perform(typeText(Integer.toString(op2)), closeSoftKeyboard());

        int expected = op1 - op2;

        onView(withId(R.id.subtractTotal)).check(matches(withText(Integer.toString(expected))));
    }

    @Test
    public void testMultiply() {

        int op1 = 54;
        int op2 = 21;

        onView(withId(R.id.multiplyOp1)).perform(typeText(Integer.toString(op1)));
        onView(withId(R.id.multiplyOp2)).perform(typeText(Integer.toString(op2)), closeSoftKeyboard());

        int expected = op1 * op2;

        onView(withId(R.id.multiplyTotal)).check(matches(withText(Integer.toString(expected))));
    }

    @Test
    public void testDivision() {

        int op1 = 120;
        int op2 = 5;

        onView(withId(R.id.divisionOp1)).perform(typeText(Integer.toString(op1)));
        onView(withId(R.id.subtractOp1)).perform(typeText(Integer.toString(op2)), closeSoftKeyboard());

        int expected = op1 / op2;

        onView(withId(R.id.subtractTotal)).check(matches(withText(Integer.toString(expected))));
    }
}

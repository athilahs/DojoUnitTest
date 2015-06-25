package com.digitalday.dojounittest;

import android.content.res.Resources;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by athila on 20/06/15.
 */
public class MainActivityInstrumentationTest {

    private static final int OPERATION_SUM = 1;
    private static final int OPERATION_SUBTRACT = 2;
    private static final int OPERATION_MULTIPLICATION = 3;
    private static final int OPERATION_DIVISION = 4;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private Resources mRes;

    @Before
    public void setup() {
        mRes = mActivityRule.getActivity().getResources();
    }

    @Test
    public void testSum() {

        String op1;
        String op2;
        String expected;

        // success case
        op1 = "32";
        op2 = "21";
        expected = Double.toString(Integer.parseInt(op1) + Integer.parseInt(op2));

        performOperation(OPERATION_SUM, op1, op2);
        onView(withId(R.id.sumTotal)).check(matches(withText(expected)));

        // first argument 3 digits
        op1 = "321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUM, op1, op2);
        onView(withId(R.id.sumTotal)).check(matches(withText(expected)));

        // second argument 3 digits
        op1 = "32";
        op2 = "218";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUM, op1, op2);
        onView(withId(R.id.sumTotal)).check(matches(withText(expected)));

        // first argument 3 digits negative
        op1 = "-321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUM, op1, op2);
        onView(withId(R.id.sumTotal)).check(matches(withText(expected)));

        // second argument 3 digits negative
        op1 = "21";
        op2 = "-456";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUM, op1, op2);
        onView(withId(R.id.sumTotal)).check(matches(withText(expected)));
    }

    @Test
    public void testSubtract() {

        String op1;
        String op2;
        String expected;

        // success case
        op1 = "32";
        op2 = "21";
        expected = Double.toString(Integer.parseInt(op1) - Integer.parseInt(op2));

        performOperation(OPERATION_SUBTRACT, op1, op2);
        onView(withId(R.id.subtractTotal)).check(matches(withText(expected)));

        // first argument 3 digits
        op1 = "321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUBTRACT, op1, op2);
        onView(withId(R.id.subtractTotal)).check(matches(withText(expected)));

        // second argument 3 digits
        op1 = "32";
        op2 = "218";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUBTRACT, op1, op2);
        onView(withId(R.id.subtractTotal)).check(matches(withText(expected)));

        // first argument 3 digits negative
        op1 = "-321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUBTRACT, op1, op2);
        onView(withId(R.id.subtractTotal)).check(matches(withText(expected)));

        // second argument 3 digits negative
        op1 = "21";
        op2 = "-456";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_SUBTRACT, op1, op2);
        onView(withId(R.id.subtractTotal)).check(matches(withText(expected)));
    }

    @Test
    public void testMultiply() {

        String op1;
        String op2;
        String expected;

        // success case
        op1 = "32";
        op2 = "21";
        expected = Double.toString(Integer.parseInt(op1) * Integer.parseInt(op2));

        performOperation(OPERATION_MULTIPLICATION, op1, op2);
        onView(withId(R.id.multiplyTotal)).check(matches(withText(expected)));

        // first argument 3 digits
        op1 = "321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_MULTIPLICATION, op1, op2);
        onView(withId(R.id.multiplyTotal)).check(matches(withText(expected)));

        // second argument 3 digits
        op1 = "32";
        op2 = "218";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_MULTIPLICATION, op1, op2);
        onView(withId(R.id.multiplyTotal)).check(matches(withText(expected)));

        // first argument 3 digits negative
        op1 = "-321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_MULTIPLICATION, op1, op2);
        onView(withId(R.id.multiplyTotal)).check(matches(withText(expected)));

        // second argument 3 digits negative
        op1 = "21";
        op2 = "-456";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_MULTIPLICATION, op1, op2);
        onView(withId(R.id.multiplyTotal)).check(matches(withText(expected)));
    }

    @Test
    public void testDivision() {

        String op1;
        String op2;
        String expected;

        // success case
        op1 = "20";
        op2 = "5";
        expected = Double.toString(Integer.parseInt(op1) / Integer.parseInt(op2));

        performOperation(OPERATION_DIVISION, op1, op2);
        onView(withId(R.id.divisionTotal)).check(matches(withText(expected)));

        // first argument 3 digits
        op1 = "321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_DIVISION, op1, op2);
        onView(withId(R.id.divisionTotal)).check(matches(withText(expected)));

        // second argument 3 digits
        op1 = "32";
        op2 = "218";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_DIVISION, op1, op2);
        onView(withId(R.id.divisionTotal)).check(matches(withText(expected)));

        // first argument 3 digits negative
        op1 = "-321";
        op2 = "21";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_DIVISION, op1, op2);
        onView(withId(R.id.divisionTotal)).check(matches(withText(expected)));

        // second argument 3 digits negative
        op1 = "21";
        op2 = "-456";
        expected = mRes.getString(R.string.invalid);

        performOperation(OPERATION_DIVISION, op1, op2);
        onView(withId(R.id.divisionTotal)).check(matches(withText(expected)));
    }

    private void performOperation(int which, String op1, String op2) {
        switch(which) {
            case OPERATION_SUM:
                onView(withId(R.id.sumOp1)).perform(clearText());
                onView(withId(R.id.sumOp1)).perform(typeText(op1));
                onView(withId(R.id.sumOp2)).perform(clearText());
                onView(withId(R.id.sumOp2)).perform(typeText(op2), closeSoftKeyboard());
                onView(withId(R.id.buttonSum)).perform(click());

                break;

            case OPERATION_SUBTRACT:
                onView(withId(R.id.subtractOp1)).perform(clearText());
                onView(withId(R.id.subtractOp1)).perform(typeText(op1));
                onView(withId(R.id.subtractOp2)).perform(clearText());
                onView(withId(R.id.subtractOp2)).perform(typeText(op2), closeSoftKeyboard());
                onView(withId(R.id.buttonSubtract)).perform(click());

                break;

            case OPERATION_MULTIPLICATION:
                onView(withId(R.id.multiplyOp1)).perform(clearText());
                onView(withId(R.id.multiplyOp1)).perform(typeText(op1));
                onView(withId(R.id.multiplyOp2)).perform(clearText());
                onView(withId(R.id.multiplyOp2)).perform(typeText(op2), closeSoftKeyboard());
                onView(withId(R.id.buttonMultiply)).perform(click());

                break;

            case OPERATION_DIVISION:
                onView(withId(R.id.divisionOp1)).perform(clearText());
                onView(withId(R.id.divisionOp1)).perform(typeText(op1));
                onView(withId(R.id.divisionOp2)).perform(clearText());
                onView(withId(R.id.divisionOp2)).perform(typeText(op2), closeSoftKeyboard());
                onView(withId(R.id.buttonDivision)).perform(click());

                break;
        }
    }
}

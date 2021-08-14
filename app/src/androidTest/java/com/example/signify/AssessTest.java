package com.example.signify;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * The test class AssessTest.
 * Instrumented test, which will execute on an Android device.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class AssessTest extends TestCase {

    /**
     * Sets up test fixture.
     *
     * Called before every test case method.
     */
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Checks that UI works correctly when user inserts data.
     * When user selects resultButton button, finish button should be visible and clickable.
     */
    @Test
    public void testUserInputAssess() {
        String a = "1";
        Espresso.onView(withId(R.id.inputOne)).perform(typeText(a));
        Espresso.onView(withId(R.id.inputTwo)).perform(typeText(a));
        String b = "4";
        Espresso.onView(withId(R.id.inputThree)).perform(typeText(b));
        Espresso.onView(withId(R.id.inputFour)).perform(typeText(a));
        Espresso.onView(withId(R.id.inputFive)).perform(typeText(b));
        Espresso.onView(withId(R.id.resultButton)).perform(click());
        Espresso.onView(withId(R.id.finish)).perform(click());
    }

    /**
     * Tears down test fixture.
     *
     * Called after every test case method.
     */
    public void tearDown() throws Exception {
    }
}
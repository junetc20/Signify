package com.example.signify;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * The test class Quiz3Test.
 * Instrumented test, which will execute on an Android device.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Quiz3Test extends TestCase {

    /**
     * Sets up test fixture.
     *
     * Called before every test case method.
     */
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Checks that UI works correctly when user clicks buttons.
     */
    @Test
    public void testUserInputQuiz3() {
        Espresso.onView(withId(R.id.falseButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.trueButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.trueButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.trueButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.falseButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.trueButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.trueButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.falseButton2)).perform(click());
        Espresso.onView(withId(R.id.nextButton3)).perform(click());
        Espresso.onView(withId(R.id.completeButton3)).perform(click());
    }

    /**
     * Tears down test fixture.
     *
     * Called after every test case method.
     */
    public void tearDown() throws Exception {
    }

}
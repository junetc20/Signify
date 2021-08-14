package com.example.signify;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * The test class Quiz1Test.
 * Instrumented test, which will execute on an Android device.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Quiz1Test extends TestCase {

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
    public void testUserInputQuiz1() {
        Espresso.onView(withId(R.id.answer1)).perform(click());
        Espresso.onView(withId(R.id.nextButton2)).perform(click());
        Espresso.onView(withId(R.id.answer3)).perform(click());
        Espresso.onView(withId(R.id.nextButton2)).perform(click());
        Espresso.onView(withId(R.id.answer1)).perform(click());
        Espresso.onView(withId(R.id.nextButton2)).perform(click());
        Espresso.onView(withId(R.id.answer2)).perform(click());
        Espresso.onView(withId(R.id.nextButton2)).perform(click());
        Espresso.onView(withId(R.id.answer1)).perform(click());
        Espresso.onView(withId(R.id.nextButton2)).perform(click());
        Espresso.onView(withId(R.id.completeButton2)).perform(click());
    }

    /**
     * Tears down test fixture.
     *
     * Called after every test case method.
     */
    public void tearDown() throws Exception {
    }
}
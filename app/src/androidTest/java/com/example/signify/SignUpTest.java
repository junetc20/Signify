package com.example.signify;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * The test class SignUpTest.
 * Instrumented test, which will execute on an Android device.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class SignUpTest extends TestCase {

    /**
     * Sets up test fixture.
     * <p>
     * Called before every test case method.
     */
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Checks that UI works correctly when user inserts data.
     */
    @Test
    public void testUserInputSignUp() {
        String a = "June";
        Espresso.onView(withId(R.id.inputFirstName)).perform(typeText(a));
        String b = "Caldwell";
        Espresso.onView(withId(R.id.inputLastName)).perform(typeText(b));
        String c = "j@gmail.com";
        Espresso.onView(withId(R.id.inputEmail)).perform(typeText(c));
        String d = "123";
        Espresso.onView(withId(R.id.createPassword)).perform(typeText(d));
        String e = "123";
        Espresso.onView(withId(R.id.reEnterPassword)).perform(typeText(e));
        Espresso.onView(withId(R.id.createAccount)).perform(click());
    }

    /**
     * Tears down test fixture.
     * <p>
     * Called after every test case method.
     */
    public void tearDown() throws Exception {
    }
}
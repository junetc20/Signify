package com.example.signify;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.content.Intent;
import android.widget.Button;

import androidx.test.espresso.Espresso;
import androidx.test.filters.MediumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * The test class AssertTest.
 * Instrumented test, which will execute on an Android device.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class AssessTest extends ActivityUnitTestCase<Assess> {

    private String a = "1";
    private String b = "4";
    private Intent mLaunchIntent;

    /**
     * Sets up test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), Assess.class);
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton = (Button) getActivity().findViewById(R.id.finish);
    }

    @MediumTest
    public void testNextActivityWasLaunchedWithIntent() {
        startActivity(mLaunchIntent, null, null);
        final Button launchNextButton = (Button) getActivity().findView
    }

    /**
     * Checks that UI works correctly when user inserts data.
     * When user selects resultButton button, finish button should be visible and clickable.
     */
    @Test
    public void testUserInputAssess() {
        Espresso.onView(withId(R.id.inputOne)).perform(typeText(a));
        Espresso.onView(withId(R.id.inputTwo)).perform(typeText(a));
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
    @After
    public void tearDown() throws Exception {
    }
}
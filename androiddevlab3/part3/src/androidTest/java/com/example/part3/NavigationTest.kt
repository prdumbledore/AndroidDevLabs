package com.example.part3

import android.content.pm.ActivityInfo
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(FirstActivity::class.java)


    private fun testAbout(bool: Boolean) {
        openAbout()
        onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
        if (bool) pressBack() else pressUp()
    }

    @Test
    fun testFirstExist() {
        launchActivity<FirstActivity>()
        testCheck(R.id.fragment1)
        pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testSecondExist() {
        launchActivity<FirstActivity>()
        onView(withId(R.id.bnToSecond))
            .perform(click())
        testCheck(R.id.fragment2)
        pressBack()
        pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testThirdExist() {
        launchActivity<FirstActivity>()
        onView(withId(R.id.bnToSecond))
            .perform(click())
        onView(withId(R.id.bnToThird))
            .perform(click())
        testCheck(R.id.fragment3)
        pressBack()
        pressBack()
        pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testAboutExist() {
        launchActivity<FirstActivity>()
        onView(withId(R.id.bnToSecond))
            .perform(click())
        onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
        pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testUpButton() {
        launchActivity<FirstActivity>()

        onView(withId(R.id.bnToSecond))
            .perform(click())
        testCheck(R.id.fragment2)
        pressUp()
        testCheck(R.id.fragment1)

        onView(withId(R.id.bnToSecond))
            .perform(click())
        onView(withId(R.id.bnToThird))
            .perform(click())
        testCheck(R.id.fragment3)
        pressUp()
        testCheck(R.id.fragment2)
        pressUp()
        testCheck(R.id.fragment1)

        testAbout(false)
        testCheck(R.id.fragment1)

        onView(withId(R.id.bnToSecond))
            .perform(click())
        testAbout(false)
        testCheck(R.id.fragment2)

        onView(withId(R.id.bnToThird))
            .perform(click())
        testAbout(false)
        testCheck(R.id.fragment3)

    }

    @Test
    fun testBackstack() {

        testAbout(true)
        testCheck(R.id.fragment1)
        onView(withId(R.id.bnToSecond))
            .perform(click())

        testCheck(R.id.fragment2)
        testAbout(true)
        onView(withId(R.id.bnToThird))
            .perform(click())

        testCheck(R.id.fragment3)
        testAbout(true)
        onView(withId(R.id.bnToFirst))
            .perform(click())

        testCheck(R.id.fragment1)
        testAbout(true)
        onView(withId(R.id.bnToSecond))
            .perform(click())

        testCheck(R.id.fragment2)
        testAbout(true)
        onView(withId(R.id.bnToFirst))
            .perform(click())

        testCheck(R.id.fragment1)
        testAbout(true)
        onView(withId(R.id.bnToSecond))
            .perform(click())

        testCheck(R.id.fragment2)
        testAbout(true)
        onView(withId(R.id.bnToThird))
            .perform(click())

        testCheck(R.id.fragment3)
        testAbout(true)
        onView(withId(R.id.bnToSecond))
            .perform(click())

        testCheck(R.id.fragment2)
        testAbout(true)
        onView(withId(R.id.bnToThird))
            .perform(click())

        testCheck(R.id.fragment3)
        testAbout(true)

    }

    @Test
    fun testRotation() {
        //first fragment test block
        testCheck(R.id.fragment1)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        testCheck(R.id.fragment1)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        testCheck(R.id.fragment1)
        //

        onView(withId(R.id.bnToSecond))
            .perform(click())

        // second fragment test block
        testCheck(R.id.fragment2)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        testCheck(R.id.fragment2)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        testCheck(R.id.fragment2)
        //

        onView(withId(R.id.bnToThird))
            .perform(click())

        // third fragment test block
        testCheck(R.id.fragment3)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        testCheck(R.id.fragment3)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        testCheck(R.id.fragment3)
        //

        openAbout()

        // about activity test block
        testCheck(R.id.activity_about)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        testCheck(R.id.activity_about)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        testCheck(R.id.activity_about)
        //
    }

    private fun pressUp() {
        onView(ViewMatchers.withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
    }

    private fun testCheck(fragment: Int) {
        when (fragment) {
            R.id.fragment1 -> {
                onView(withId(R.id.bnToFirst))
                    .check(doesNotExist())
                onView(withId(R.id.bnToSecond))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.bnToThird))
                    .check(doesNotExist())
                onView(withId(R.id.fragment1))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.fragment2))
                    .check(doesNotExist())
                onView(withId(R.id.fragment3))
                    .check(doesNotExist())
                onView(withId(R.id.activity_about))
                    .check(doesNotExist())
            }
            R.id.fragment2 -> {
                onView(withId(R.id.bnToFirst))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.bnToThird))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.bnToSecond))
                    .check(doesNotExist())
                onView(withId(R.id.fragment1))
                    .check(doesNotExist())
                onView(withId(R.id.fragment2))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.fragment3))
                    .check(doesNotExist())
                onView(withId(R.id.activity_about))
                    .check(doesNotExist())
            }
            R.id.fragment3 -> {
                onView(withId(R.id.bnToFirst))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.bnToSecond))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.bnToThird))
                    .check(doesNotExist())
                onView(withId(R.id.fragment1))
                    .check(doesNotExist())
                onView(withId(R.id.fragment2))
                    .check(doesNotExist())
                onView(withId(R.id.fragment3))
                    .check(matches(isDisplayed()))
                onView(withId(R.id.activity_about))
                    .check(doesNotExist())
            }
            R.id.activity_about -> {
                onView(withId(R.id.bnToFirst))
                    .check(doesNotExist())
                onView(withId(R.id.bnToSecond))
                    .check(doesNotExist())
                onView(withId(R.id.bnToThird))
                    .check(doesNotExist())
            }
        }
    }
}
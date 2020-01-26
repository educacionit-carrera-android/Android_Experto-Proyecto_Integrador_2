package com.example.mvpexample.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.mvpexample.HomeActivity
import com.example.mvpexample.R
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(LoginActivity::class.java)

    companion object {
        @JvmStatic
        @BeforeClass
        fun setup() {
            Intents.init()
        }
    }

    /*@Test
    fun btnCreate_isDisplayed() {
        onView(withId(R.id.btnCreate))
            .check(matches(isDisplayed()))
    }

    @Test
    fun btnCreate_and_btnLogin_are_enabled_when_activity_is_launched() {
        onView(withId(R.id.btnCreate))
            .check(matches(isEnabled()))

        onView(withId(R.id.btnLogin))
            .check(matches(isEnabled()))
    }

    @Test
    fun click_btnCreate() {
        onView(withId(R.id.btnCreate))
            .perform(click())
    }*/

    @Test
    fun should_show_toast_error_when_email_and_password_are_empty() {
        onView(withId(R.id.etEmail))
            .perform(typeText(""))

        onView(withId(R.id.etPassword))
            .perform(typeText(""))

        onView(withId(R.id.btnLogin))
            .perform(click())

        onView(withText("Información inválida"))
            .inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun should_show_toast_error_when_email_is_empty() {
        onView(withId(R.id.etEmail))
            .perform(typeText(""))

        onView(withId(R.id.etPassword))
            .perform(typeText("123456"))

        onView(withId(R.id.btnLogin))
            .perform(click())

        onView(withText("Información inválida"))
            .inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun should_show_toast_error_when_password_is_empty() {
        onView(withId(R.id.etEmail))
            .perform(typeText("prueba@test.com"))

        onView(withId(R.id.etPassword))
            .perform(typeText(""))

        onView(withId(R.id.btnLogin))
            .perform(click())

        onView(withText("Información inválida"))
            .inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun should_display_HomeActivity_when_data_is_valid_and_btnLogin_is_clicked() {
        onView(withId(R.id.etEmail))
            .perform(typeText("prueba@test.com"))

        onView(withId(R.id.etPassword))
            .perform(typeText("123456"))

        onView(withId(R.id.btnLogin))
            .perform(click())

        Thread.sleep(3100)
        intended(hasComponent(HomeActivity::class.java.name))
    }

}
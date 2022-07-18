package com.example.sicrediandroidtest

import org.junit.Assert
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sicrediandroidtest.adapter.EventAdapter
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import com.example.sicrediandroidtest.idlingResource.IdleResource
import org.junit.Rule
import androidx.test.espresso.assertion.ViewAssertions.matches


@RunWith(AndroidJUnit4::class)
class EventCrudTest: Assert() {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun isClickEventOpenScreenDetails() {
        IdlingRegistry.getInstance().register(IdleResource.instance)
        onView(withId(R.id.rvEvents))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<EventAdapter.EventViewHolder>(0, click()))
        onView(withId(R.id.btnDetailsEventClose)).check(matches(isDisplayed()))
        onView(withId(R.id.btnDetailsEventClose)).perform(click())
    }
}
package com.hoon.booksearch.ui.view

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

//@RunWith(RobolectricTestRunner::class)
//class MainActivityTest {
//
//    @Test
//    @SmallTest
//    fun test_activity_state() {
//        val controller = Robolectric.setupActivity(MainActivity::class.java)
//        val activityState = controller.lifecycle.currentState.name
//        assertThat(activityState).isEqualTo("RESUMED")
//    }
//}

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    @SmallTest
    fun test_activity_state() {
//        val activityState = activityScenario.state.name
        val activityState = activityScenarioRule.scenario.state.name
        assertThat(activityState).isEqualTo("RESUMED")
    }
}



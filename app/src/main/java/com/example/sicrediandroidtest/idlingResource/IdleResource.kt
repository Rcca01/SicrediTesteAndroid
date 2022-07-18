package com.example.sicrediandroidtest.idlingResource

import androidx.test.espresso.idling.CountingIdlingResource

object IdleResource {
    val instance = CountingIdlingResource("EVENTS")
}
package com.example.sicrediandroidtest

import androidx.lifecycle.ViewModel
import com.example.sicrediandroidtest.repository.EventHttp

class EventViewModel(private val eventHttp: EventHttp): ViewModel() {

    fun getListEvents() = eventHttp.getListEvents()
    fun getDetailsEvent(idEvent: Int) = eventHttp.getDetailsEvent(idEvent)
}
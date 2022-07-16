package com.example.sicrediandroidtest.di

import com.example.sicrediandroidtest.EventViewModel
import com.example.sicrediandroidtest.repository.EventHttp
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val androidModule = module {
    viewModel {
        (eventHttp: EventHttp) -> EventViewModel(eventHttp)
    }
}
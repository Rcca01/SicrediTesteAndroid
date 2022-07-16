package com.example.sicrediandroidtest.di

import com.example.sicrediandroidtest.EventViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val androidModule = module {
    viewModel {
        EventViewModel()
    }
}
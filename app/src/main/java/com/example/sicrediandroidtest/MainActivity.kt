package com.example.sicrediandroidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sicrediandroidtest.repository.EventHttp
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val viewModel: EventViewModel by viewModel{
        parametersOf(EventHttp())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getListEvents()
        viewModel.getDetailsEvent(1)
    }
}
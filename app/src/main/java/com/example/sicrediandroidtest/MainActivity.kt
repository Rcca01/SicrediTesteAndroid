package com.example.sicrediandroidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sicrediandroidtest.adapter.EventAdapter
import com.example.sicrediandroidtest.model.Event
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var rvEvents: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private val viewModel: EventViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_events)
        rvEvents = findViewById(R.id.rvEvents)
        initRecycleView()
        viewModel.getListEvents(this)
    }

    private fun initRecycleView() {
        viewModel.listEvents().observe(this, Observer {
            eventAdapter = EventAdapter(it, this::onItemClick)
            rvEvents.adapter = eventAdapter
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rvEvents.layoutManager = layoutManager
        })
    }

    private fun onItemClick(v: View, event: Event, position: Int) {
        Log.d("Clicado", event.title)
    }
}
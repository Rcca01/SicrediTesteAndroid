package com.example.sicrediandroidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sicrediandroidtest.idlingResource.IdleResource
import com.example.sicrediandroidtest.adapter.EventAdapter
import com.example.sicrediandroidtest.model.Event
import com.example.sicrediandroidtest.model.User
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var rvEvents: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private lateinit var progressBar: ProgressBar
    private var singUpButton: Button? = null
    private val viewModel: EventViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_events)
        rvEvents = findViewById(R.id.rvEvents)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        initRecycleView()
        viewModel.getListEvents(this)

    }

    private fun initRecycleView() {
        viewModel.listEvents().observe(this, Observer {
            eventAdapter = EventAdapter(it, this::onItemClick, this)
            rvEvents.adapter = eventAdapter
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rvEvents.layoutManager = layoutManager
            progressBar.visibility = View.GONE
            IdleResource.instance.decrement()
        })
        viewModel.userSingUpEvent().observe(this, { signUp ->
            signUp?.let {
                if(it)
                    Toast.makeText(this, "Congratulation! CheckIn OK.", Toast.LENGTH_LONG)
                        .show()
                else{
                    singUpButton?.isEnabled = true
                    Toast.makeText(this, "Failure CheckIn", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    private fun onItemClick(event: Event) {
        val dialogDetailsEvent = BottomDialogDetailsEvent(event, this::onSignUpEvent)
        dialogDetailsEvent.show(supportFragmentManager, "DetailEvent")
    }

    private fun onSignUpEvent(idEvent: String, button:Button) {
        this.singUpButton = button
        button.isEnabled = false
        val user = User(idEvent, "Raul Cardoso", "cavalcante.cardoso@gmail.com")
        viewModel.checkInEvent(user)
    }
}
package com.example.sicrediandroidtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sicrediandroidtest.R
import com.example.sicrediandroidtest.model.Event
import com.squareup.picasso.Picasso

class EventAdapter(
    private val listEvents: List<Event>,
    private val onItemClick: (View, Event, Int) -> Unit
): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        val vh = EventViewHolder(v)
        vh.layoutEvent.setOnClickListener { view ->
            val position = vh.absoluteAdapterPosition
            val event = listEvents[position]
            onItemClick(view, event, position)
        }
        return vh
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = listEvents[position]
        holder.run {
            Picasso.get()
                .load(event.image)
                .into(imgEvent)
            txtTitleEvent?.text = event.title
        }
    }

    override fun getItemCount(): Int = listEvents.size

    class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imgEvent: ImageView? = view.findViewById(R.id.ivImageEvent)
        var txtTitleEvent: TextView? =  view.findViewById(R.id.tvTitleEvent)
        var layoutEvent: ConstraintLayout = view.findViewById(R.id.layoutEvent)
    }
}
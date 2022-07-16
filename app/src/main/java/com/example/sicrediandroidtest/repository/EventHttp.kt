package com.example.sicrediandroidtest.repository

import android.util.Log
import com.example.sicrediandroidtest.Utils.NetworkUtils
import com.example.sicrediandroidtest.model.Event
import com.example.sicrediandroidtest.model.interfaces.EventHttpApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventHttp {

    private val retrofitClient = NetworkUtils
        .getRetrofitInstance(EventHttpApi.WEB_SERVICE)

    private val eventHttpApi = retrofitClient.create(EventHttpApi::class.java)

    fun getListEvents() {
        val response = eventHttpApi.listEvents()
        response.enqueue(object: Callback<List<Event>>{
            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                Log.d("Success", response.isSuccessful.toString())
            }
        })
    }

    fun getDetailsEvent(idEvent: Int) {
        val response = eventHttpApi.listDetailsEvent(idEvent)
        response.enqueue(object: Callback<Event>{
            override fun onFailure(call: Call<Event>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                Log.d("Success", response.isSuccessful.toString())
            }
        })
    }

}
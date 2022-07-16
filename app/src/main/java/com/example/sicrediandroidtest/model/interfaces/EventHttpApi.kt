package com.example.sicrediandroidtest.model.interfaces

import com.example.sicrediandroidtest.model.Event
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface EventHttpApi {

    @Headers("Content-Type: application/json")
    @GET("api/events/")
    fun listEvents(): Call<List<Event>>

    @Headers("Content-Type: application/json")
    @GET("api/events/{event}")
    fun listDetailsEvent(@Path("event") event: Int): Call<Event>

    companion object {
        const val WEB_SERVICE = "https://5f5a8f24d44d640016169133.mockapi.io/"
    }
}
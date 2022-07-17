package com.example.sicrediandroidtest.model.interfaces

import com.example.sicrediandroidtest.model.Event
import com.example.sicrediandroidtest.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.POST
import retrofit2.http.Body

interface EventHttpApi {

    @Headers("Content-Type: application/json")
    @GET("events/")
    fun listEvents(): Call<List<Event>>

    @Headers("Content-Type: application/json")
    @GET("events/{event}")
    fun listDetailsEvent(@Path("event") event: Int): Call<Event>

    @Headers("Content-Type: application/json")
    @POST("checkin")
    fun sendCheckInEvent(@Body user: User): Call<Any>

    companion object {
        const val WEB_SERVICE = "https://5f5a8f24d44d640016169133.mockapi.io/api/"
    }
}
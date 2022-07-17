package com.example.sicrediandroidtest

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sicrediandroidtest.utils.NetworkUtils
import com.example.sicrediandroidtest.model.Event
import com.example.sicrediandroidtest.model.User
import com.example.sicrediandroidtest.model.interfaces.EventHttpApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventViewModel: ViewModel() {

    private val listMutEvents: MutableLiveData<List<Event>> = MutableLiveData()
    fun listEvents(): LiveData<List<Event>> = listMutEvents

    private val singUpEvent = MutableLiveData<Boolean>()
    fun userSingUpEvent(): LiveData<Boolean> = singUpEvent

    val retrofitClient = NetworkUtils
        .getRetrofitInstance(EventHttpApi.WEB_SERVICE)

    val eventHttpApi = retrofitClient.create(EventHttpApi::class.java)

    fun getListEvents(context: Context) {
        val response = eventHttpApi.listEvents()
        response.enqueue(object: Callback<List<Event>> {
            override fun onFailure(call: Call<List<Event>>, t: Throwable)  {
                Toast.makeText(context, "Failure API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if(response.isSuccessful)
                    listMutEvents.postValue(response.body())
                else
                    Toast.makeText(context, "Error load events", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getDetailsEvent(idEvent: Int) {
        val response = eventHttpApi.listDetailsEvent(idEvent)
        response.enqueue(object: Callback<Event> {
            override fun onFailure(call: Call<Event>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                Log.d("Success", response.isSuccessful.toString())
            }
        })
    }

    fun checkInEvent(user:User){
        val response = eventHttpApi.sendCheckInEvent(user)
        response.enqueue(object: Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                singUpEvent.postValue(false)
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful)
                    singUpEvent.postValue(true)
                else
                    singUpEvent.postValue(false)
            }
        })
    }
}
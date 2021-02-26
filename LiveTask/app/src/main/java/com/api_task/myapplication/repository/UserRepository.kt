package com.api_task.myapplication.repository

import com.api_task.myapplication.api.ApiClient
import com.api_task.myapplication.api.Network
import com.api_task.myapplication.model.ResponseModel
import retrofit2.Callback

class UserRepository(private val callback: Callback<ResponseModel>) {
    fun getUsersLists(){
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.gourav()
        /***
        Once the response is fetched, navigate the user back to view model as this callback is being implemented
        in the Viewmodel class
         */
        call.enqueue(callback)
    }
}
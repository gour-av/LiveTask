package com.api_task.myapplication.api

import com.api_task.myapplication.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("/get_payload/")
    fun gourav():Call<ResponseModel>
}
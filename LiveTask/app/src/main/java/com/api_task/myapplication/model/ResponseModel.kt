package com.api_task.myapplication.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ResponseModel(

	@field:SerializedName("message")
	val message: List<MessageItem?>? = null
)
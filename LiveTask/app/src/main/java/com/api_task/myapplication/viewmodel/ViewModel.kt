package com.api_task.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.api_task.myapplication.model.MessageItem
import com.api_task.myapplication.model.ResponseModel
import com.api_task.myapplication.repository.UserRepository
import com.api_task.myapplication.ui.UIModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/***
 * This is the viewmodel class where we are getting the response from the api using retrofit
 */
class ViewModel :ViewModel(), Callback<ResponseModel> {
    private val repository = UserRepository(this)

    private val mutableLiveData = MutableLiveData<UIModel>()
    val liveData: LiveData<UIModel> = mutableLiveData

    override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
        response.body()?.let {
            mutableLiveData.value = UIModel.Success(it.message as List<MessageItem>)
        }
    }

    override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
        mutableLiveData.value = UIModel.Failure(t.message!!)
    }
    fun callAPI() {
        repository.getUsersLists()
    }
}
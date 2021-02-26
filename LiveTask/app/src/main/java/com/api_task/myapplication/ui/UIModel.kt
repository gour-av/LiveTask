package com.api_task.myapplication.ui

import com.api_task.myapplication.model.MessageItem

sealed class UIModel {
    data class Success(val dataModelList: List<MessageItem>) : UIModel()

    data class Failure(val error: String) : UIModel()
}
package com.api_task.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.api_task.myapplication.adapter.RecyclerAdapter
import com.api_task.myapplication.api.ApiClient
import com.api_task.myapplication.model.MessageItem
import com.api_task.myapplication.ui.UIModel
import com.api_task.myapplication.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_response.*

/***
 * In this activity we are getting the output through the api
 */
class ResponseActivity : AppCompatActivity() {
    private lateinit var userViewModel: ViewModel
    private lateinit var userAdapter: RecyclerAdapter
    private val dataModelList = emptyList<MessageItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_response)
        userViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        setRecyclerAdapter()
        observeLiveData()
        userViewModel.callAPI()

    }
    private fun observeLiveData() {
        userViewModel.liveData.observe(this, Observer {
            when (it) {
                is UIModel.Success -> {
                    userAdapter.updateList(it.dataModelList)

                }
                is UIModel.Failure -> {
                    Toast.makeText(
                        this@ResponseActivity,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        })
    }
    private fun setRecyclerAdapter() {
        userAdapter = RecyclerAdapter(dataModelList)
        val layoutManager = LinearLayoutManager(this)
        recycler_view.apply {
            this.layoutManager = layoutManager
            adapter = userAdapter
        }
    }
}
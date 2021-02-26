package com.api_task.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val email = "test@gmail.com"
    private val password = "test@2020"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
           btn_auth.setOnClickListener(View.OnClickListener {
               var str_1: String = ed_name.text.toString()
               var str_2: String = ed_pass.text.toString()
               if (!str_1.equals(email)) {
                   ed_name.setError("Invalid Email");


               }
               if (!str_2.equals(password)) {
                   ed_pass.setError("Invalid Password");

               }
               if(str_1.equals(email) && str_2.equals(password)) {
                   openActivity()
               } 
           })

    }
    fun openActivity(){
        val intent = Intent(this@MainActivity, ResponseActivity::class.java)
        startActivity(intent)
    }
}
package com.example.pl_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity_lifecycleScope_and_viewModelScope : AppCompatActivity() {

    val LOG_TAG = "LOG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartActivity.setOnClickListener {
//            GlobalScope.launch {
            lifecycleScope.launch {
                while (true) {
                    delay(1000L)
                    Log.e(LOG_TAG, "Still running...")
                }
            }
//            GlobalScope.launch {
            lifecycleScope.launch {
                delay(5000L)
                Intent(
                    this@MainActivity_lifecycleScope_and_viewModelScope,
                    SecondActivity::class.java
                ).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "This is the answer"
    }
}
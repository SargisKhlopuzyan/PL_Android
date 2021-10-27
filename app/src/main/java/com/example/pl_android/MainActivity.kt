package com.example.pl_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            delay(6000L)
            Log.e("LOG_TAG", "Coroutine says hello thread ${Thread.currentThread().name}")

            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()

            Log.e("LOG_TAG", networkCallAnswer)
            Log.e("LOG_TAG", networkCallAnswer2)
        }

        Log.e("LOG_TAG", "Hello thread ${Thread.currentThread().name}")
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
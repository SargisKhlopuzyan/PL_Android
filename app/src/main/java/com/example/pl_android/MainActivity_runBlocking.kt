package com.example.pl_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity_runBlocking : AppCompatActivity() {

    val LOG_TAG = "LOG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(LOG_TAG, "Before runBlocking")

        runBlocking {

            launch(Dispatchers.IO) {
                delay(3000L)
                Log.e(LOG_TAG, "Finished IO Coroutine 1")
            }

            launch(Dispatchers.IO) {
                delay(3000L)
                Log.e(LOG_TAG, "Finished IO Coroutine 2")
            }

            Log.e(LOG_TAG, "Start of runBlocking")
            delay(5000L)
            Log.e(LOG_TAG, "End of runBlocking")
        }

        Log.e(LOG_TAG, "After runBlocking")
    }
}
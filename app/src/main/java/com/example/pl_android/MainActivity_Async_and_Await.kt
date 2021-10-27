package com.example.pl_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity_Async_and_Await : AppCompatActivity() {

    val LOG_TAG = "LOG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {

            val time = measureTimeMillis {
                val answer1: Deferred<String> = async { networkCall1() }
                val answer2: Deferred<String> = async { networkCall2() }
                Log.e("LOG_TAG", "Answer1 is ${answer1.await()}")
                Log.e("LOG_TAG", "Answer2 is ${answer2.await()}")
            }
            Log.e("LOG_TAG", "Requests took $time ms.")
        }

    }

    suspend fun networkCall1(): String {
        delay(3000L)
        return "Answer1"
    }

    suspend fun networkCall2(): String {
        delay(3000L)
        return "Answer2"
    }
}
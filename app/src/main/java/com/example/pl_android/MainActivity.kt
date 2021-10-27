package com.example.pl_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val LOG_TAG = "LOG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Coroutine Contexts - Kotlin Coroutines
         *
         *************************************************************************************************
         * Dispatchers.Main    -    Will start a coroutine in the main thread - UI updates
         *************************************************************************************************
         * Dispatchers.IO      -    Which is just used for all kinds of data operations such as networking
         *                          writing to databases or reading and writing to files
         *************************************************************************************************
         * Dispatchers.Default -    Which you should choose if you're planning on doing complex and long
         *                          running calculations that will block the main thread so let's say you
         *                          need to sort a list of 10.000 elements then you should do that in the
         *                          default dispatcher to not block your main thread na your UI
         *************************************************************************************************
         * Dispatchers.Unconfined - Unconfined is not as the name says it's not confined to a specific
         *                          thread, so if you start a coroutine and Unconfined that causes a span
         *                          function it will stay in the thread that the suspend function resumed
         * */
//        GlobalScope.launch(newSingleThreadContext("MyThread")) {
        GlobalScope.launch(Dispatchers.IO) {
            Log.e(LOG_TAG, "Starting coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()

            withContext(Dispatchers.Main) {
                Log.e(LOG_TAG, "Setting text in thread ${Thread.currentThread().name}")
                tvDummy.text= answer
            }
        }

        // Suspend Functions - Kotlin Coroutines
/*        GlobalScope.launch {
            delay(6000L)
            Log.e("LOG_TAG", "Coroutine says hello thread ${Thread.currentThread().name}")

            val networkCallAnswer = doNetworkCall()
            val networkCallAnswer2 = doNetworkCall2()

            Log.e("LOG_TAG", networkCallAnswer)
            Log.e("LOG_TAG", networkCallAnswer2)
        }

        Log.e("LOG_TAG", "Hello thread ${Thread.currentThread().name}")*/
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
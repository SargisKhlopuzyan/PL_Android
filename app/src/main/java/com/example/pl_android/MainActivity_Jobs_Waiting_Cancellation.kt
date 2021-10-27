package com.example.pl_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity_Jobs_Waiting_Cancellation : AppCompatActivity() {

    val LOG_TAG = "LOG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.e(LOG_TAG, "Starting long running calculation...")

            withTimeout(3000L) {
                for (i in 30..40) {
                    if (isActive) {
                        Log.e(LOG_TAG, "Result for i = $i: ${fib(i)}")
                    }
                }
            }

//            for (i in 30..40) {
//                if (isActive) {
//                    Log.e(LOG_TAG, "Result for i = $i: ${fib(i)}")
//                }
//            }

            Log.e(LOG_TAG, "Ending long running calculation...")

//            repeat(5) {
//                Log.e(LOG_TAG, "Coroutine is still working...")
//                delay(1000L)
//            }
        }

        runBlocking {
            delay(2000L)
//            job.join()
            job.cancel()
            Log.e(LOG_TAG, "Canceled job!")
        }

        Log.e(LOG_TAG, "Main Thread is continuing...")

    }

    private fun fib(n: Int): Long {
        return when (n) {
            0 -> 0
            1 -> 1
            else -> fib(n - 1) + fib(n - 2)
        }
    }

}
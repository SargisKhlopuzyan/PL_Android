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

        GlobalScope.launch{
            delay(6000L)
            Log.e("LOG_TAG", "Coroutine says hello thread ${Thread.currentThread().name}")
        }

        Log.e("LOG_TAG", "Hello thread ${Thread.currentThread().name}")
    }
}
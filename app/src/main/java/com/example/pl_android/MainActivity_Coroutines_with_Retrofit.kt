package com.example.pl_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity_Coroutines_with_Retrofit : AppCompatActivity() {

    val LOG_TAG = "LOG_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)

        /** v2 */
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getComments_v1().awaitResponse()
            if(response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.e(LOG_TAG, comment.toString())
                }
            }
        }

        /** v1 */
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getComments_v2()
            if(response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.e(LOG_TAG, comment.toString())
                }
            }
        }

        /** v1 - no error handling */
//        GlobalScope.launch(Dispatchers.IO) {
//            val comments = api.getComments_v1().await()
//            for (comment in comments) {
//                Log.e(LOG_TAG, comment.toString())
//            }
//        }

        /** old way */
//        api.getComments_v1().enqueue(object : Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        for (comment in it) {
//                            Log.e(LOG_TAG, comment.toString())
//                        }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                Log.e(LOG_TAG, "ERROR: $t")
//            }
//        })


    }

}
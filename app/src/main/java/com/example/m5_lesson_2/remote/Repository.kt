package com.example.m5_lesson_2.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLove(firstName:String, secondName: String): MutableLiveData<LoveModel> {
        val liveLove = MutableLiveData<LoveModel>()

        RetrofitService().api.percentageNames(firstName, secondName).enqueue(object: Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if(response.isSuccessful) {
                    liveLove.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ahaha", "onFailure: ${t.message}")
            }

        })

        return liveLove
    }
}
package com.example.m5_lesson_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.m5_lesson_2.databinding.ActivityMainBinding
import com.example.m5_lesson_2.remote.LoveModel
import com.example.m5_lesson_2.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }

    private fun initClickers() {
        binding.bntCalculate.setOnClickListener {
            RetrofitService().api.percentageNames(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString()
            ).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
//                    Log.e("ololo", "onResponse: ${response.body()}")
                    var intent = Intent(this@MainActivity, MainActivity2::class.java).apply {
                        putExtra("firstName", binding.etFirstName.text.toString())
                        putExtra("secondName", binding.etSecondName.text.toString())
                    }
                    startActivity(intent)
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })
        }
    }
}
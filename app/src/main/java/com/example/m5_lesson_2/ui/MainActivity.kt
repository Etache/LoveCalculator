package com.example.m5_lesson_2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.m5_lesson_2.remote.LoveViewModel
import com.example.m5_lesson_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }

    private fun initClickers() {
        binding.bntCalculate.setOnClickListener {
            viewModel.liveLove(binding.etFirstName.text.toString(), binding.etSecondName.text.toString())
                .observe(this@MainActivity) { loveModel ->
                    Log.e("ahaha", "initClickers: ${loveModel}")
                }
        }
    }
}



/*
 RetrofitService().api.percentageNames(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString()
            ).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
//                    Log.e("ololo", "onResponse: ${response.body()}")
                    var intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                        putExtra("firstName", binding.etFirstName.text.toString())
                        putExtra("secondName", binding.etSecondName.text.toString())
                    }
                    startActivity(intent)
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })*/
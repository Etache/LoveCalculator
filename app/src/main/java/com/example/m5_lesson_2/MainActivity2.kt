package com.example.m5_lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m5_lesson_2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var firstEtValue = intent.getStringExtra("firstName")
        var secondEtValue = intent.getStringExtra("secondName")

        binding.tvFirstName.text = firstEtValue
        binding.tvSecondName.text = secondEtValue
    }
}
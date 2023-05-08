package com.example.m5_lesson_2.remote

import com.google.gson.annotations.SerializedName

data class LoveModel (
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String
)
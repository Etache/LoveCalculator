package com.example.m5_lesson_2.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class LoveViewModel: ViewModel() {

    val repository = Repository()

    fun liveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }

}
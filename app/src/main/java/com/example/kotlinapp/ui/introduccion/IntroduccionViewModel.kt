package com.example.kotlinapp.ui.introduccion


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IntroduccionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is introduccion Fragment"
    }
    val text: LiveData<String> = _text
}
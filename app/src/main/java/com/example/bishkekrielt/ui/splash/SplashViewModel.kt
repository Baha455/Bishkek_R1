package com.example.bishkekrielt.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class SplashViewModel() : ViewModel() {

    fun initSplashScreen() {
        viewModelScope.launch(Dispatchers.Main) {
            delay(2000)

        }
    }

}

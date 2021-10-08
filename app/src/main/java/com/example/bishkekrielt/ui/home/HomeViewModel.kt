package com.example.bishkekrielt.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bishkekrielt.data.interactors.RieltInteractor
import com.example.bishkekrielt.data.model.*
import kotlinx.coroutines.launch

class HomeViewModel(private val service: RieltInteractor ) : ViewModel() {

    val catalog = MutableLiveData<List<Recatalog>>()

    fun getData() {
        viewModelScope.launch {
            kotlin.runCatching {
                val rieltProject = service.loadDescription2()
                if (rieltProject.isSuccessful) catalog.postValue(rieltProject.body()?.catalog)

            }

        }
    }

    /*fun getDataForRv() {
        viewModelScope.launch {
            kotlin.runCatching {
                val rieltProject2 = service.loadDescription2()
                if (rieltProject2.isSuccessful) catalog.postValue(rieltProject2.body()?.catalog)
            }.onFailure {
                    Log.d("гэгэ2", it.message ?: "гэгэ2")
            }
        }

    }*/
}


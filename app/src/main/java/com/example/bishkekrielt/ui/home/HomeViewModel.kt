package com.example.bishkekrielt.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bishkekrielt.data.repository.Repository
import com.example.bishkekrielt.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class HomeViewModel(private val service: Repository ) : ViewModel() {

    val catalog = MutableLiveData<List<Recatalog>>()

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                val rieltProject = service.loadDescription()
                if (rieltProject.isSuccessful) catalog.postValue(rieltProject.body()?.catalog)

            }

        }
    }

}


package com.example.bishkekrielt.ui.home

import androidx.lifecycle.*
import com.example.bishkekrielt.data.repository.Repository
import com.example.bishkekrielt.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val service: Repository, savedStateHandle: SavedStateHandle ) : ViewModel() {

    val catalog = MutableLiveData<List<Recatalog>>()

    private val _catalog = savedStateHandle.getLiveData("catalog", getData())
    //val catalog1: MutableLiveData<Recatalog> = _catalog

    fun getData(){
    viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            val rieltProjection = service.loadDescription()
            if (rieltProjection.isSuccessful) catalog.postValue(rieltProjection.body()?.catalog)
        }
    }
}
}


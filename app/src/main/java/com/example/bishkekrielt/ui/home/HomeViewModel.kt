package com.example.bishkekrielt.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bishkekrielt.data.model.Recatalog
import com.example.bishkekrielt.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val service: Repository, savedStateHandle: SavedStateHandle ) : ViewModel() {

    val catalog = MutableLiveData<List<Recatalog>>()

    private val _catalog = savedStateHandle.getLiveData("catalog", getData())
    //val catalog1: MutableLiveData<> = _catalog
    /*val filteretData: LiveData<List<String>> =
        savedStateHandle.getLiveData<String>("query").switchMap {  }*/



    fun getData(){
    viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {

            val rieltProjection = service.loadDescription()
            if (rieltProjection.isSuccessful) catalog.postValue(rieltProjection.body()?.catalog)
        }
    }
}
}


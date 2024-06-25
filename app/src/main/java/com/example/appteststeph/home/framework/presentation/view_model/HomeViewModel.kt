package com.example.appteststeph.home.framework.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appteststeph.home.data.repository.BrandsRepository
import com.example.appteststeph.home.framework.presentation.screen.state.HomeUiState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repositoryImpl: BrandsRepository
) : ViewModel() {

    private val _state = MutableLiveData<HomeUiState>()
    val state : LiveData<HomeUiState>
        get () = _state

    init {
        fetchBrands();
    }

    private fun fetchBrands() {
        viewModelScope.launch(IO) {
            val brandsList =  repositoryImpl.getBrands()
            _state.postValue(HomeUiState.Data(
                brands = brandsList
            ))
        }
    }
}
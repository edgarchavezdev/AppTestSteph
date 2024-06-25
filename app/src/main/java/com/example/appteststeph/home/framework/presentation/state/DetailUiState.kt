package com.example.appteststeph.home.framework.presentation.screen.state

import com.example.appteststeph.home.domain.models.BrandItem


sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Data(val brands: List<BrandItem>) : HomeUiState
}
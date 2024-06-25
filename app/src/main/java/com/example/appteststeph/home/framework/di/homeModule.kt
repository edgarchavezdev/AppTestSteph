package com.example.appteststeph.home.framework.di

import com.example.appteststeph.home.data.data_source.BrandsLocalDataSource
import com.example.appteststeph.home.data.data_source.BrandsRemoteDataSource
import com.example.appteststeph.home.data.repository.BrandsRepository
import com.example.appteststeph.home.framework.implementation.data.datasource.BrandsLocalDataSourceImpl
import com.example.appteststeph.home.framework.implementation.data.datasource.BrandsRemoteDataSourceImpl
import com.example.appteststeph.home.framework.implementation.data.repository.BrandsRepositoryImpl
import com.example.appteststeph.home.framework.presentation.view_model.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    factory<BrandsLocalDataSource> {
        BrandsLocalDataSourceImpl(
            get(),
        )
    }

    factory<BrandsRemoteDataSource> {
        BrandsRemoteDataSourceImpl(
            get(),
        )
    }

    factory<BrandsRepository> {
        BrandsRepositoryImpl(
            get(),
            get(),
        )
    }

    viewModel {
        HomeViewModel(get())
    }
}
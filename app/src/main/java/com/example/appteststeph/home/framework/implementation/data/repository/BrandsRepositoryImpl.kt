package com.example.appteststeph.home.framework.implementation.data.repository

import com.example.appteststeph.home.data.data_source.BrandsLocalDataSource
import com.example.appteststeph.home.data.data_source.BrandsRemoteDataSource
import com.example.appteststeph.home.data.repository.BrandsRepository
import com.example.appteststeph.home.domain.models.BrandItem

class BrandsRepositoryImpl(
    private val dataSourceLocal: BrandsLocalDataSource,
    private val dataSourceRemote: BrandsRemoteDataSource,
) : BrandsRepository {

    override suspend fun getBrands(): List<BrandItem> {
        val brandsLocal = dataSourceLocal.getBrands()
        return if (brandsLocal.isEmpty()) {
            val brandsRemote = dataSourceRemote.getBrands()
            dataSourceLocal.insertBrands(brandsRemote.toTypedArray())
            brandsRemote.map {
                BrandItem(
                    code = it.code,
                    name = it.name
                )
            }.toList()
        } else {
            brandsLocal.map {
                BrandItem(
                    code = it.code,
                    name = it.name
                )
            }.toList()
        }
    }
}
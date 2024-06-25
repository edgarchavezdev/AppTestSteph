package com.example.appteststeph.home.data.data_source

import com.example.appteststeph.commons.database.models.BrandsDto

interface BrandsRemoteDataSource {
    suspend fun getBrands() : List<BrandsDto>;
}
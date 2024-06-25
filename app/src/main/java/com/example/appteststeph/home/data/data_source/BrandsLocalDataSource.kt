package com.example.appteststeph.home.data.data_source

import com.example.appteststeph.commons.database.models.BrandsDto

interface BrandsLocalDataSource {
    suspend fun getBrands() : List<BrandsDto>;
    suspend fun insertBrands(list: Array<BrandsDto>);
}
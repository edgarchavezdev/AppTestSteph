package com.example.appteststeph.home.framework.implementation.data.datasource

import com.example.appteststeph.commons.database.database.AppDatabase
import com.example.appteststeph.commons.database.models.BrandsDto
import com.example.appteststeph.home.data.data_source.BrandsLocalDataSource

class BrandsLocalDataSourceImpl(
    private val database: AppDatabase
) : BrandsLocalDataSource {
    override suspend fun getBrands() : List<BrandsDto> {
        return database.brandsDao().getBrands();
    }

    override suspend fun insertBrands(list: Array<BrandsDto>) {
        database.brandsDao().insertBrand(autos = list);
    }
}
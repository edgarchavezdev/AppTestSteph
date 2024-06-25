package com.example.appteststeph.home.data.repository

import com.example.appteststeph.home.domain.models.BrandItem

interface BrandsRepository {
    suspend fun getBrands() : List<BrandItem>;
}
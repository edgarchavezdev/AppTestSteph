package com.example.appteststeph.home.framework.implementation.data.datasource

import com.example.appteststeph.commons.database.models.BrandsDto
import com.example.appteststeph.commons.network.Network
import com.example.appteststeph.commons.util.URL_BASE
import com.example.appteststeph.home.data.data_source.BrandsRemoteDataSource
import com.example.appteststeph.home.framework.implementation.data.config.BrandsApi

class BrandsRemoteDataSourceImpl(
    private val network: Network,
) : BrandsRemoteDataSource {
    override suspend fun getBrands(): List<BrandsDto> {
        val response =
            network.getInstance(URL_BASE).create(BrandsApi::class.java).getBrandsAsync().await()

        return try {
            if (response.isSuccessful) {
                response.body()?.map {
                    BrandsDto(
                        name = it.nome,
                        code = it.codigo
                    )
                } ?: listOf()
            } else {
                listOf()
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            listOf()
        }
    }
}
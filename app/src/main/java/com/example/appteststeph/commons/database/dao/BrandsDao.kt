package com.example.appteststeph.commons.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appteststeph.commons.database.models.BrandsDto

/**
 * BrandsDao
 */
@Dao
interface BrandsDao {
    @Query("SELECT * FROM Brands")
    fun getBrands(): List<BrandsDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBrand(vararg autos: BrandsDto)

    @Query("DELETE FROM Brands")
    fun deleteAutos()
}
package com.example.appteststeph.commons.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appteststeph.commons.database.dao.BrandsDao
import com.example.appteststeph.commons.database.models.BrandsDto

/**
 * AppDataBase
 */
@Database(entities = [BrandsDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun brandsDao(): BrandsDao
}
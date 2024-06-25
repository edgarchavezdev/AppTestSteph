package com.example.appteststeph.commons.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * AutoItem
 */
@Entity(tableName = "Brands")
data class BrandsDto(
        @PrimaryKey()
        @ColumnInfo val code: String,
        @ColumnInfo val name: String,
)

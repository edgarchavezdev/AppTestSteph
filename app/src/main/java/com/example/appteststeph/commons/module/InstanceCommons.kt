package com.example.appteststeph.commons.module

import androidx.room.Room
import com.example.appteststeph.commons.database.database.AppDatabase
import com.example.appteststeph.commons.network.Network
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val instanceCommons = module {

    single {
        Network()
    }

    single {
        Room.databaseBuilder(
            androidContext(), AppDatabase::class.java, "app_test_stephanini"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }
}
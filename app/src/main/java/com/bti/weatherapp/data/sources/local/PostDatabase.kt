package com.bti.weatherapp.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bti.weatherapp.data.models.DPost
import com.bti.weatherapp.data.sources.local.dao.PostDatabaseDao

@Database(
    entities = [DPost::class],
    version = 1,
    exportSchema = false,
)
abstract class PostDatabase : RoomDatabase() {

    abstract fun getPostDatabaseDao(): PostDatabaseDao

}
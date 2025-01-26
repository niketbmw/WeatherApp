package com.bti.weatherapp.data.sources.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bti.weatherapp.data.models.DPost
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDatabaseDao {
    @Query("SELECT * FROM post_table LIMIT 1")
    fun getPost(): Flow<DPost?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: DPost)
}
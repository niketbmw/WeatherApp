package com.bti.weatherapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bti.weatherapp.domain.entities.Post

@Entity(tableName = "post_table")
data class DPost(
    val userId: Int,
    @PrimaryKey(autoGenerate = false) val id: Int,
    val title: String,
    val body: String
)

fun DPost.toDomain(): Post {
    return Post(
        id = id.toFloat(),
        title = title,
        body = body
    )
}
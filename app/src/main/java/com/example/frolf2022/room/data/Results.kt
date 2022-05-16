package com.example.discgolf.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Results (
    @PrimaryKey(autoGenerate = false)
    val win : Int
        )
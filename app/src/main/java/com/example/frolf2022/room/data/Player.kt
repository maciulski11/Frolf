package com.example.discgolf.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity -> jest wejsciem dla naszej bazy danych users
@Entity//nazywamy tabele z danymi
data class Player(
    @PrimaryKey(autoGenerate = false)
    val playerName: String
)

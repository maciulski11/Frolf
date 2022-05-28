package com.example.discgolf.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey


//Entity -> jest wejsciem dla naszej  bazy danych competitions
@Entity//nazywamy tabele z danymi
data class Competitions(
    @PrimaryKey(autoGenerate = false)
    val nameCompetitions: String,
    val playerName: String
)
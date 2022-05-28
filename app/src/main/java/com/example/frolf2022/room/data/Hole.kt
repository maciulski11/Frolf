package com.example.discgolf.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hole (
    @PrimaryKey(autoGenerate = false)
    val holeAcount : Int,
    val movement: Int,
    val nameCompetitions: String,
    val playerName: String
)
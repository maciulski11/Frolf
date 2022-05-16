package com.example.discgolf.room.data.relations

import androidx.room.Entity

@Entity(primaryKeys = ["playerName", "win"])
class PlayersResultsCrossRef (
    val playerName: String,
    val win: Int
)
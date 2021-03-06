package com.example.discgolf.room.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Player

data class CompetitionsAndPlayer(
    @Embedded val competitions: Competitions,
    @Relation(
        parentColumn = "playerName",
        entityColumn = "playerName"
    )
    val player: List<Player>
)
package com.example.discgolf.room.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Hole

data class CompetitionsAndHole(
    @Embedded val competitions: Competitions,
    @Relation(
        parentColumn = "nameCompetitions",
        entityColumn = "nameCompetitions"
    )
    val hole: List<Hole>
)
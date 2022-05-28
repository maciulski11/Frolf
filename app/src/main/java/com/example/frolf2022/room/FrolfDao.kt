package com.example.discgolf.room

import androidx.room.*
import androidx.room.Dao
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Hole
import com.example.discgolf.room.data.Player
import com.example.discgolf.room.data.relations.CompetitionsAndHole
import com.example.discgolf.room.data.relations.CompetitionsAndPlayer
import com.example.discgolf.room.data.relations.PlayersResultsCrossRef

//Data Access Object -> DAO
@Dao //ten interfejs mowi nam na jakie operacje w bazie danych pozwalamy
interface FrolfDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //IGNORE) -> oznacza ze np. jak pojawi sie dokladnie ten sam
    suspend fun insertCompetitions(competitions: Competitions) //competitions to ma po prostu zignorwac

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: Player)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHole(hole: Hole)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayerResultsCrossRef(playerResults: PlayersResultsCrossRef)


    @Transaction
    @Query("SELECT * FROM competitions WHERE nameCompetitions = :nameCompetitions")
    suspend fun getCompetitionsAndPlayer(nameCompetitions: String): List<CompetitionsAndPlayer>

    @Transaction
    @Query("SELECT * FROM competitions WHERE nameCompetitions = :nameCompetitions")
    suspend fun getCompetitionsWithHole(nameCompetitions: String): List<CompetitionsAndHole>
}
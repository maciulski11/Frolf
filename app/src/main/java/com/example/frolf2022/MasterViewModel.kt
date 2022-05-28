package com.example.frolf2022

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Player
import com.example.discgolf.room.data.relations.PlayersResultsCrossRef
import com.example.frolf2022.room.Repository

class MasterViewModel(application: Application): AndroidViewModel(application) {

    private var reposiotry: Repository = //-> tworzymy nasze repositorium
        Repository(application)

    fun addCompetitions(competitions: Competitions){
        reposiotry.insertCompetition(competitions)
    }

    fun addPlayer(player: Player){
        reposiotry.insertPlayer(player)
    }
}
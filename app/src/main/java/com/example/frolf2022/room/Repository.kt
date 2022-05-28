package com.example.frolf2022.room

import android.app.Application
import com.example.discgolf.room.FrolfDao
import com.example.discgolf.room.FrolfDatabase
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Player
import com.example.discgolf.room.data.relations.PlayersResultsCrossRef
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

//klasa ktora decyduje o tym jakie informacje przekazac dalej, zeby pomiedzy
//bazami danych nie doszlo do desynchronizacji i ta kalasa decyduje co ma przechodzic dalej
class Repository(application: Application) {

    private var frolfDao: FrolfDao // zmienna ktora przechowa nasz interfejs

    init {   // na starcie w init tworzymy nasza baze danych wykorzystujac kod ktory
        val database = FrolfDatabase  //napisalismy wczesniej
            .getDatebase(application.applicationContext)

        //a gdy juz uchwycimy nasza baze danych to uzywamy metody peopleDao:
        frolfDao =database.frolfDao
    }

    fun insertCompetition(competitions: Competitions) : Job=
        CoroutineScope(Dispatchers.IO).launch {
            frolfDao.insertCompetitions(competitions)
        }

    fun insertPlayer(player: Player) : Job=
        CoroutineScope(Dispatchers.IO).launch {
            frolfDao.insertPlayer(player)
        }

}
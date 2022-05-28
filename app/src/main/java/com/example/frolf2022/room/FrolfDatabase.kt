package com.example.discgolf.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Hole
import com.example.discgolf.room.data.Player
import com.example.discgolf.room.data.Results
import com.example.discgolf.room.data.relations.PlayersResultsCrossRef


//TA KLASA MUSI BYC ABSTRAKCYJNA BO ROOMDATABSE TEGO WYMAGA!

//entities -> co jest wejsciem dla bazy danych
// version -> jaka to jest wersja bazy danych, im wiecej tym wieksza wersja
//exportSchema -> export danych zawsze jest true i nie trzeba go pisac chyba ze chcemy flase
@Database(
    entities = [
        Competitions::class,
        Player::class,
        Hole::class,
        Results::class,
        PlayersResultsCrossRef::class
    ],

    version = 2
)
abstract class FrolfDatabase : RoomDatabase() {

    //tworzymy abstrakcyjna fun ktora zwraca interfejs (uzytkownika lub objekt dostepu do danych)
    abstract val frolfDao: FrolfDao

    //tworzymy obiekt naszej bazy danych i mozemy stworzyc go tylko raz a pozniej go edytowac i zmieniac
    companion object {
        @Volatile
        private var INSTANCE: FrolfDatabase? = null

        fun getDatebase(context: Context): FrolfDatabase {
            var instance = INSTANCE

            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    FrolfDatabase::class.java,
                    "competitions"
                ).build()
            }

            return instance
        }
    }
}
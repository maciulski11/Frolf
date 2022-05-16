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

@Database(
    entities = [
        Competitions::class,
        Player::class,
        Hole::class,
        Results::class,
        PlayersResultsCrossRef::class
    ],

    version = 1
)
abstract class FrolfDatabase: RoomDatabase(){

    abstract val frolfDao : FrolfDao

    companion object {
        @Volatile
        private var INSTANCE: FrolfDatabase? = null

        fun getInstance(context: Context): FrolfDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    FrolfDatabase::class.java,
                    "competitions_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
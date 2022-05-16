package com.example.frolf2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.discgolf.room.FrolfDatabase
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Hole
import com.example.discgolf.room.data.Player
import com.example.discgolf.room.data.relations.PlayersResultsCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
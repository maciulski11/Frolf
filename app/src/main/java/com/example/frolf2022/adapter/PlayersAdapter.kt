package com.example.frolf2022.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.discgolf.room.data.Player
import com.example.frolf2022.R

class PlayersAdapter(private val playerList: List<Player>): //wprowadzilem parametr o nzawie delete, ktory
    RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {      //ma wsobie playera i zwraca nic(unit lub void)
    //mosze go we fragmnciee okeslic co robi...

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = playerList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]

        holder.name.text = player.playerName
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.namePlayer)


    }
}
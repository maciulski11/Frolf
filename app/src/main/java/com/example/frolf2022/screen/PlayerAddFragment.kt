package com.example.frolf2022.screen

import android.text.TextUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.discgolf.room.data.Player
import com.example.frolf2022.MasterViewModel
import com.example.frolf2022.R
import com.example.frolf2022.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_player_add.*

class PlayerAddFragment: BaseFragment() {
    override val layout: Int = R.layout.fragment_player_add

    private val viewModel: MasterViewModel by viewModels()

    override fun subscribeUi() {

        savePlayer.setOnClickListener {
            insertDataToDAtabse()
            editText.setText("")
        }

    }

    private fun insertDataToDAtabse() {
        val name = editText.text.toString()

        if (inputCheck(name)) {

            val player = Player(name)
            viewModel.addPlayer(player)
        //    findNavController().navigate(R.id.action_playerAddFragment_to_rankingPlayerFragment)
        }
    }

    //fun sprawdza czy dane (imie) nie sa puste
    private fun inputCheck(name: String): Boolean {
        return !(TextUtils.isEmpty(name))
    }

    override fun unsubscribeUi() {

    }
}
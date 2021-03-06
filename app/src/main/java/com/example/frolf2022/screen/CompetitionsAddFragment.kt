package com.example.frolf2022.screen

import android.text.TextUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.discgolf.room.FrolfDatabase
import com.example.discgolf.room.data.Competitions
import com.example.discgolf.room.data.Hole
import com.example.discgolf.room.data.Player
import com.example.discgolf.room.data.relations.PlayersResultsCrossRef
import com.example.frolf2022.MasterViewModel
import com.example.frolf2022.R
import com.example.frolf2022.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_competitions_add.*
import kotlinx.coroutines.launch

class CompetitionsAddFragment : BaseFragment() {
    override val layout: Int = R.layout.fragment_competitions_add

    //pobierasz instancje viewmodelu czyli taki daj mi tu viewmodel
    private val viewModel: MasterViewModel by viewModels()

    override fun subscribeUi() {

        val dao = FrolfDatabase.getDatebase(requireContext()).frolfDao

        save.setOnClickListener {
            insertDataToDAtabse()
            nameCompetitions.setText("")
        }



        val competitions = listOf(
            Competitions("Boguszow", ""),
            Competitions("Wałbrzych", ""),
            Competitions("Wroclaw", "")
        )

        val player = listOf(
            Player("Maciej"),
            Player("Maciej"),
            Player("Ania"),
            Player("Lusiek"),
            Player("Drois"),
            Player("Henryk")

        )
        val hole = listOf(
            Hole(11, 12, "Boguszow" , ""),
            Hole(14, 1211, "Boguszow", ""),
            Hole(15, 122, "Boguszow", ""),
            Hole(9, 132, "Wroclaw", ""),
            Hole(4, 1, "Wałbrzych" , ""),
            Hole(21, 21, "Wałbrzych", "")
        )

        val playerResult = listOf(
            PlayersResultsCrossRef("Maciej", 5),
            PlayersResultsCrossRef("Ania", 3),
            PlayersResultsCrossRef("Lusiek", 2),
            PlayersResultsCrossRef("Henryk", 44),
            PlayersResultsCrossRef("Henryk", 44),


            )

        lifecycleScope.launch {
            competitions.forEach { dao.insertCompetitions(it) }
            player.forEach { dao.insertPlayer(it) }
            hole.forEach { dao.insertHole(it) }
            playerResult.forEach { dao.insertPlayerResultsCrossRef(it) }
        }

    }

    private fun insertDataToDAtabse() {

        val name = nameCompetitions.text.toString()

        if (inputCheck(name)) {

            val comp = Competitions(name, "")

            viewModel.addCompetitions(comp)

        }
    }

    //fun sprawdza czy dane (imie) nie sa puste
    private fun inputCheck(name: String): Boolean {
        return !(TextUtils.isEmpty(name))
    }

    override fun unsubscribeUi() {

    }
}
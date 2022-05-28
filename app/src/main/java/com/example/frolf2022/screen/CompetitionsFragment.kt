package com.example.frolf2022.screen

import androidx.navigation.fragment.findNavController
import com.example.frolf2022.R
import com.example.frolf2022.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_competitions.*

class CompetitionsFragment: BaseFragment() {
    override val layout: Int = R.layout.fragment_competitions

    override fun subscribeUi() {
        addCompetitionsBT.setOnClickListener {
            findNavController().navigate(R.id.action_competitionsFragment_to_competitionsAddFragment)
        }
    }

    override fun unsubscribeUi() {

    }
}
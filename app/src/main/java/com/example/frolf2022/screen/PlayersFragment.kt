package com.example.frolf2022.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.discgolf.room.data.Player
import com.example.frolf2022.MasterViewModel
import com.example.frolf2022.R
import com.example.frolf2022.adapter.PlayersAdapter
import com.example.frolf2022.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_players.*

class PlayersFragment: BaseFragment() {
    override val layout: Int = R.layout.fragment_players

    private lateinit var playersList: LiveData<List<Player>>
    private lateinit var playerAdapter: PlayersAdapter
    private lateinit var viewModel: MasterViewModel

    override fun subscribeUi() {

        //RecyclerView:
        recyclerViewPlayers.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerViewPlayers.setHasFixedSize(true)

        //ViewModel: -> podpinamy viewmodel do fragmentu !!-> pamitaj ze viewmodel zawsze uruchamiamy w aktywnosci!!!
        viewModel = ViewModelProvider(this)[MasterViewModel::class.java]

        addPlayerBT.setOnClickListener {
            findNavController().navigate(R.id.action_playersFragment_to_playerAddFragment)
        }
    }

    override fun unsubscribeUi() {

    }
}
package dev.randallgreene.basketballstats.ui


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer


class PlayerAveragesFragment : PlayerStatsFragment() {

    private lateinit var regularPlayerAveragesRecyclerViewAdapter: PlayerAveragesRecyclerViewAdapter
    private lateinit var playoffPlayerAveragesRecyclerViewAdapter: PlayerAveragesRecyclerViewAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        regularPlayerAveragesRecyclerViewAdapter =
            PlayerAveragesRecyclerViewAdapter(requireContext())
        regularSeasonRecyclerView.adapter = regularPlayerAveragesRecyclerViewAdapter


        playoffPlayerAveragesRecyclerViewAdapter =
            PlayerAveragesRecyclerViewAdapter(requireContext())
        playoffsRecyclerView.adapter = playoffPlayerAveragesRecyclerViewAdapter


        viewModel.player.observe(this, Observer { player ->
            regularPlayerAveragesRecyclerViewAdapter.setPlayerSeasonAverages(player.regularSeasonAverages)
            playoffPlayerAveragesRecyclerViewAdapter.setPlayerSeasonAverages(player.playoffAverages)
        })
    }


}

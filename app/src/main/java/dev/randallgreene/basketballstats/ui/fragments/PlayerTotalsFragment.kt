package dev.randallgreene.basketballstats.ui.fragments


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer

import dev.randallgreene.basketballstats.ui.adapters.PlayerShootingRecyclerViewAdapter
import dev.randallgreene.basketballstats.ui.adapters.PlayerTotalsRecyclerViewAdapter


class PlayerTotalsFragment : PlayerStatsFragment() {

    private lateinit var regularPlayerShootingRecyclerViewAdapter: PlayerTotalsRecyclerViewAdapter
    private lateinit var playoffPlayerShootingRecyclerViewAdapter: PlayerTotalsRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        regularPlayerShootingRecyclerViewAdapter =
            PlayerTotalsRecyclerViewAdapter(
                requireContext()
            )
        regularSeasonRecyclerView.adapter = regularPlayerShootingRecyclerViewAdapter

        playoffPlayerShootingRecyclerViewAdapter =
            PlayerTotalsRecyclerViewAdapter(
                requireContext()
            )
        playoffsRecyclerView.adapter = playoffPlayerShootingRecyclerViewAdapter

        viewModel.player.observe(this, Observer { player ->
            regularPlayerShootingRecyclerViewAdapter.setPlayerSeasonShooting(player.regularSeasonStats)
            playoffPlayerShootingRecyclerViewAdapter.setPlayerSeasonShooting(player.playoffStats)
        })
    }
}

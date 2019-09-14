package dev.randallgreene.basketballstats.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import dev.randallgreene.basketballstats.ui.adapters.PlayerShootingRecyclerViewAdapter

class PlayerShootingFragment : PlayerStatsFragment() {

    private lateinit var regularPlayerShootingRecyclerViewAdapter: PlayerShootingRecyclerViewAdapter
    private lateinit var playoffPlayerShootingRecyclerViewAdapter: PlayerShootingRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        regularPlayerShootingRecyclerViewAdapter =
            PlayerShootingRecyclerViewAdapter(
                requireContext()
            )
        regularSeasonRecyclerView.adapter = regularPlayerShootingRecyclerViewAdapter

        playoffPlayerShootingRecyclerViewAdapter =
            PlayerShootingRecyclerViewAdapter(
                requireContext()
            )
        playoffsRecyclerView.adapter = playoffPlayerShootingRecyclerViewAdapter

        viewModel.player.observe(this, Observer { player ->
            regularPlayerShootingRecyclerViewAdapter.setPlayerSeasonShooting(player.regularSeasonStats)
            playoffPlayerShootingRecyclerViewAdapter.setPlayerSeasonShooting(player.playoffStats)
        })
    }
}
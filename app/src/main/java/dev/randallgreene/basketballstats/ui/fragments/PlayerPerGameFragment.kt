package dev.randallgreene.basketballstats.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import dev.randallgreene.basketballstats.ui.adapters.PlayerPerGameRecyclerViewAdapter

class PlayerPerGameFragment : PlayerStatsFragment() {

    private lateinit var regularPlayerPerGameRecyclerViewAdapter: PlayerPerGameRecyclerViewAdapter
    private lateinit var playoffPlayerPerGameRecyclerViewAdapter: PlayerPerGameRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        regularPlayerPerGameRecyclerViewAdapter =
            PlayerPerGameRecyclerViewAdapter(
                requireContext()
            )
        regularSeasonRecyclerView.adapter = regularPlayerPerGameRecyclerViewAdapter

        playoffPlayerPerGameRecyclerViewAdapter =
            PlayerPerGameRecyclerViewAdapter(
                requireContext()
            )
        playoffsRecyclerView.adapter = playoffPlayerPerGameRecyclerViewAdapter

        viewModel.player.observe(viewLifecycleOwner, Observer { player ->
            regularPlayerPerGameRecyclerViewAdapter.setPlayerSeasonShooting(player.regularSeasonStats)
            playoffPlayerPerGameRecyclerViewAdapter.setPlayerSeasonShooting(player.playoffStats)
        })
    }
}
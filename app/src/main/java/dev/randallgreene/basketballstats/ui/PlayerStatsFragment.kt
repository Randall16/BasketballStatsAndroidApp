package dev.randallgreene.basketballstats.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import dev.randallgreene.basketballstats.R
import dev.randallgreene.basketballstats.viewmodels.PlayerViewModel

/**
 * A simple [Fragment] subclass.
 */
open class PlayerStatsFragment : Fragment() {

    protected lateinit var viewModel: PlayerViewModel
    protected lateinit var regularSeasonRecyclerView: RecyclerView
    protected lateinit var playoffsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_player_stats, container, false)

        // Find recyclerviews and attach layoutManager to them
        regularSeasonRecyclerView = root.findViewById(R.id.regularSesaonRecyclerView)
        regularSeasonRecyclerView.layoutManager = LinearLayoutManager(context)
        playoffsRecyclerView = root.findViewById(R.id.playoffsRecyclerView)
        playoffsRecyclerView.layoutManager = LinearLayoutManager(context)

        // Find viewModel
        viewModel = ViewModelProviders.of(requireActivity()).get(PlayerViewModel::class.java)

        return root
    }


}

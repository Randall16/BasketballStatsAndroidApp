/**
 * This class is meant to be extended. Most of the player statistics fragments consist of two
 * recycler views that display data living in the PlayerViewModel. This class abstracts out the
 * process of finding the two recycler views and view model.
 */
package dev.randallgreene.basketballstats.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import dev.randallgreene.basketballstats.R
import dev.randallgreene.basketballstats.viewmodels.PlayerViewModel


abstract class PlayerStatsFragment : Fragment() {

    protected val viewModel
        get() = _viewModel

    protected val regularSeasonRecyclerView
        get() = _regularSeasonRecyclerView

    protected val playoffsRecyclerView
        get() = _playoffsRecyclerView

    private lateinit var _viewModel: PlayerViewModel
    private lateinit var _regularSeasonRecyclerView: RecyclerView
    private lateinit var _playoffsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_player_stats, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find recyclerviews and attach layoutManager to them
        _regularSeasonRecyclerView = view.findViewById(R.id.regularSeasonRecyclerView)
        _regularSeasonRecyclerView.layoutManager = LinearLayoutManager(context)

        _playoffsRecyclerView = view.findViewById(R.id.playoffsRecyclerView)
        playoffsRecyclerView.layoutManager = LinearLayoutManager(context)


        // Find viewModel
        _viewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)
    }


}

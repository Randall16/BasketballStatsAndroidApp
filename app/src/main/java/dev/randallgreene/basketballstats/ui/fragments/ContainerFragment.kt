// This fragment has the viewPager and holds the other fragments to be scrolled through.
package dev.randallgreene.basketballstats.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import dev.randallgreene.basketballstats.R
import dev.randallgreene.basketballstats.ui.adapters.ViewPagerAdapter
import dev.randallgreene.basketballstats.viewmodels.PlayerViewModel

import kotlinx.android.synthetic.main.fragment_player_stats_container.view.*


class ContainerFragment : Fragment() {

    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_player_stats_container, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create the viewPager
        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        addAdapterToViewPager(viewPager)

        // Link with tabs from xml
        view.tabs.setupWithViewPager(viewPager)

        // set up progress bar
        progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        subscribeToViewModel()
    }

    private fun addAdapterToViewPager(viewPager: ViewPager) {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)

        viewPagerAdapter.addFragment(PlayerAveragesFragment(), "Averages")
        viewPagerAdapter.addFragment(PlayerShootingFragment(), "Shooting")


        viewPager.adapter = viewPagerAdapter
    }

    private fun subscribeToViewModel() {
        val viewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)

        viewModel.isLoading.observe(this, Observer {isLoading ->
            if (isLoading)
                progressBar.visibility = View.VISIBLE
            else
                progressBar.visibility = View.INVISIBLE
        })
    }
}

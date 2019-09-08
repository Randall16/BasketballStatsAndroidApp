package dev.randallgreene.basketballstats.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import dev.randallgreene.basketballstats.R

import kotlinx.android.synthetic.main.fragment_player_stats_container.view.*


class PlayerStatsContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_player_stats_container, container, false)

        // Create the viewPager
        val viewPager = root.findViewById<ViewPager>(R.id.viewPager)
        addAdapterToViewPager(viewPager)

        // Link with tabs from xml
        root.tabs.setupWithViewPager(viewPager)

        return root
    }

    private fun addAdapterToViewPager(viewPager: ViewPager) {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)

        viewPagerAdapter.addFragment(PlayerAveragesFragment(), "Averages")
        viewPagerAdapter.addFragment(PlayerTotalsFragment(), "Totals")

        viewPager.adapter = viewPagerAdapter
    }


}

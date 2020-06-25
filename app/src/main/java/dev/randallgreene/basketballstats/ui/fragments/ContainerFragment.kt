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
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
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
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        addAdapterToViewPager(viewPager)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabs)

        val titles = listOf("Averages", "Shooting", "Per Game", "Totals")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()

        // set up progress bar
        progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        subscribeToViewModel()
    }

    private fun addAdapterToViewPager(viewPager: ViewPager2) {
        val viewPagerAdapter = ViewPagerAdapter(requireActivity())

        viewPagerAdapter.addFragment(PlayerAveragesFragment())
        viewPagerAdapter.addFragment(PlayerShootingFragment())
        viewPagerAdapter.addFragment(PlayerPerGameFragment())
        viewPagerAdapter.addFragment(PlayerTotalsFragment())

        viewPager.adapter = viewPagerAdapter
    }

    private fun subscribeToViewModel() {
        val viewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {isLoading ->
            if (isLoading)
                progressBar.visibility = View.VISIBLE
            else
                progressBar.visibility = View.INVISIBLE
        })
    }
}

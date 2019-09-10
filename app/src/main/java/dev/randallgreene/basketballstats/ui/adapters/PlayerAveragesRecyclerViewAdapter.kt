package dev.randallgreene.basketballstats.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import dev.randallgreene.basketballstats.R
import dev.randallgreene.basketballstats.data.models.PlayerSeason

class PlayerAveragesRecyclerViewAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<PlayerAveragesRecyclerViewAdapter.SeasonAveragesItemHolder>() {

    private var items = listOf<PlayerSeason>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private val whiteColor = ResourcesCompat.getColor(context.resources, R.color.white, null)
    private val alternateRowColor = ResourcesCompat.getColor(context.resources, R.color.alternateRowColor, null)


    inner class SeasonAveragesItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val yearTextView = itemView.findViewById<TextView>(R.id.yearTextView)
        val teamTextView = itemView.findViewById<TextView>(R.id.teamTextView)
        val ageTextView = itemView.findViewById<TextView>(R.id.ageTextView)
        val gamesPlayedTextView = itemView.findViewById<TextView>(R.id.gamesPlayedTextView)
        val totalReboundsTextView = itemView.findViewById<TextView>(R.id.fieldGoalPercentageTextView)
        val assistsTextView = itemView.findViewById<TextView>(R.id.threePointPercentageTextView)
        val stealsTextView = itemView.findViewById<TextView>(R.id.twoPercentageTextView)
        val blocksTextView = itemView.findViewById<TextView>(R.id.effectiveFieldGoalPercentage)
        val turnoversTextView = itemView.findViewById<TextView>(R.id.freeThrowTextView)
        val pointsTextView = itemView.findViewById<TextView>(R.id.trueShootingTextView)
    }

    fun setPlayerSeasonAverages(playerSeasons: List<PlayerSeason>) {
        this.items = playerSeasons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonAveragesItemHolder {
        val itemView = inflater.inflate(R.layout.stats_averages_layout, parent,false)
        return SeasonAveragesItemHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SeasonAveragesItemHolder, position: Int) {

        if (position == 0) {
            holder.yearTextView.text = "Year"
            holder.teamTextView.text = "Tm"
            holder.ageTextView.text = "Age"
            holder.gamesPlayedTextView.text = "GP"
            holder.totalReboundsTextView.text = "REB"
            holder.assistsTextView.text = "AST"
            holder.stealsTextView.text = "STL"
            holder.blocksTextView.text = "BLK"
            holder.turnoversTextView.text = "TOV"
            holder.pointsTextView.text = "PTS"
            holder.itemView.setBackgroundColor(alternateRowColor)
        }
        else {
            val rowColor = if (position % 2 == 0) alternateRowColor else whiteColor
            val currentItem = items[position - 1]
            holder.yearTextView.text = currentItem.year.toString()
            holder.teamTextView.text = currentItem.team
            holder.ageTextView.text = currentItem.age?.toString() ?: ""
            holder.gamesPlayedTextView.text = currentItem.totalGamesPlayed?.toString() ?: ""
            holder.totalReboundsTextView.text = currentItem.totalReboundsPerGame?.toString() ?: ""
            holder.assistsTextView.text = currentItem.assistsPerGame?.toString() ?: ""
            holder.stealsTextView.text = currentItem.stealsPerGame?.toString() ?: ""
            holder.blocksTextView.text = currentItem.blocksPerGame?.toString() ?: ""
            holder.turnoversTextView.text = currentItem.turnoversPerGame?.toString() ?: ""
            holder.pointsTextView.text = currentItem.pointsPerGame?.toString() ?: ""

            holder.itemView.setBackgroundColor(rowColor)
        }
    }

    override fun getItemCount() = items.size + 1
}
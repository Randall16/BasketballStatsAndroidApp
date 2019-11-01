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
import dev.randallgreene.basketballstats.ui.displayValue

class PlayerAveragesRecyclerViewAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<PlayerAveragesRecyclerViewAdapter.SeasonAveragesItemHolder>() {

    private var items = listOf<PlayerSeason>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private val whiteColor = ResourcesCompat.getColor(context.resources, R.color.white, null)
    private val alternateRowColor = ResourcesCompat.getColor(context.resources, R.color.alternateRowColor, null)


    inner class SeasonAveragesItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val yearTextView = itemView.findViewById<TextView>(R.id.yearTextView)
        val teamTextView = itemView.findViewById<TextView>(R.id.teamTextView)
        val gamesPlayedTextView = itemView.findViewById<TextView>(R.id.gamesPlayedTextView)
        val minutesTextView = itemView.findViewById<TextView>(R.id.minutesTextView)
        val totalReboundsTextView = itemView.findViewById<TextView>(R.id.reboundsTextView)
        val assistsTextView = itemView.findViewById<TextView>(R.id.assistsTextView)
        val stealsTextView = itemView.findViewById<TextView>(R.id.stealsTextView)
        val blocksTextView = itemView.findViewById<TextView>(R.id.blocksTextView)
        val turnoversTextView = itemView.findViewById<TextView>(R.id.turnoversTextView)
        val pointsTextView = itemView.findViewById<TextView>(R.id.pointsTextView)
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
            holder.minutesTextView.text = "Min"
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
            holder.yearTextView.displayValue(currentItem.year)

            holder.teamTextView.displayValue(currentItem.team)
            holder.minutesTextView.displayValue(currentItem.minutesPerGame)
            holder.gamesPlayedTextView.displayValue(currentItem.totalGamesPlayed)
            holder.totalReboundsTextView.displayValue(currentItem.totalReboundsPerGame)
            holder.assistsTextView.displayValue(currentItem.assistsPerGame)
            holder.stealsTextView.displayValue(currentItem.stealsPerGame)
            holder.blocksTextView.displayValue(currentItem.blocksPerGame)
            holder.turnoversTextView.displayValue(currentItem.turnoversPerGame)
            holder.pointsTextView.displayValue(currentItem.pointsPerGame)

            holder.itemView.setBackgroundColor(rowColor)
        }
    }

    override fun getItemCount() = items.size + 1
}
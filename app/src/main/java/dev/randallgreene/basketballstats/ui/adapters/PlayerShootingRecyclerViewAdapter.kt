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
import dev.randallgreene.basketballstats.ui.displayPercentValue
import dev.randallgreene.basketballstats.ui.displayValue

class PlayerShootingRecyclerViewAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<PlayerShootingRecyclerViewAdapter.SeasonShootingItemHolder>() {

    private var items = listOf<PlayerSeason>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private val whiteColor = ResourcesCompat.getColor(context.resources, R.color.white, null)
    private val alternateRowColor = ResourcesCompat.getColor(context.resources, R.color.alternateRowColor, null)


    inner class SeasonShootingItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val yearTextView = itemView.findViewById<TextView>(R.id.yearTextView)
        val teamTextView = itemView.findViewById<TextView>(R.id.teamTextView)
        val ageTextView = itemView.findViewById<TextView>(R.id.ageTextView)
        val gamesPlayedTextView = itemView.findViewById<TextView>(R.id.gamesPlayedTextView)
        val fieldGoalPercentageTextView = itemView.findViewById<TextView>(R.id.fieldGoalPercentageTextView)
        val threePercentageTextView = itemView.findViewById<TextView>(R.id.threePointPercentageTextView)
        val twoPercentageTextView = itemView.findViewById<TextView>(R.id.twoPercentageTextView)
        val effectiveFieldGoalPercentageTextView = itemView.findViewById<TextView>(R.id.effectiveFieldGoalPercentage)
        val freeThrowPercentageTextView = itemView.findViewById<TextView>(R.id.freeThrowTextView)
        val trueShootingPercentageTextView = itemView.findViewById<TextView>(R.id.trueShootingTextView)
    }

    fun setPlayerSeasonShooting(playerSeasons: List<PlayerSeason>) {
        this.items = playerSeasons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonShootingItemHolder {
        val itemView = inflater.inflate(R.layout.stats_shooting_layout, parent, false)
        return SeasonShootingItemHolder(itemView)
    }

    override fun getItemCount(): Int = items.size + 1

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SeasonShootingItemHolder, position: Int) {

        if (position == 0) {
            holder.yearTextView.text = "Year"
            holder.teamTextView.text = "Tm"
            holder.ageTextView.text = "Age"
            holder.gamesPlayedTextView.text = "GP"
            holder.fieldGoalPercentageTextView.text = "FG%"
            holder.threePercentageTextView.text = "3P%"
            holder.twoPercentageTextView.text = "2P%"
            holder.effectiveFieldGoalPercentageTextView.text = "eFG%"
            holder.freeThrowPercentageTextView.text = "FT%"
            holder.trueShootingPercentageTextView.text = "TS%"

            holder.itemView.setBackgroundColor(alternateRowColor)
        }
        else {
            val rowColor = if (position % 2 == 0) alternateRowColor else whiteColor
            val currentItem = items[position - 1]
            holder.yearTextView.displayValue(currentItem.year)
            holder.teamTextView.displayValue(currentItem.team)
            holder.ageTextView.displayValue(currentItem.age)
            holder.gamesPlayedTextView.displayValue(currentItem.totalGamesPlayed)
            holder.fieldGoalPercentageTextView.displayPercentValue(currentItem.fieldGoalPercentage)
            holder.threePercentageTextView.displayPercentValue(currentItem.threePercentage)
            holder.twoPercentageTextView.displayPercentValue(currentItem.twoPercentage)
            holder.effectiveFieldGoalPercentageTextView.displayPercentValue(currentItem.effectiveFieldGoalPercentage)
            holder.freeThrowPercentageTextView.displayPercentValue(currentItem.freeThrowPercentage)
            holder.trueShootingPercentageTextView.displayPercentValue(currentItem.trueShootingPercentage)

            holder.itemView.setBackgroundColor(rowColor)
        }
    }



}
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

class PlayerPerGameRecyclerViewAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<PlayerPerGameRecyclerViewAdapter.SeasonShootingPerGameItemHolder>() {


    private var items = listOf<PlayerSeason>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private val whiteColor = ResourcesCompat.getColor(context.resources, R.color.white, null)
    private val alternateRowColor = ResourcesCompat.getColor(context.resources, R.color.alternateRowColor, null)


    inner class SeasonShootingPerGameItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val yearTextView = itemView.findViewById<TextView>(R.id.yearTextView)
        val teamTextView = itemView.findViewById<TextView>(R.id.teamTextView)
        val gamesPlayedTextView = itemView.findViewById<TextView>(R.id.gamesPlayedTextView)
        val gamesStartedTextView = itemView.findViewById<TextView>(R.id.gamesStartedTextView)
        val fieldGoalsTotalTextView = itemView.findViewById<TextView>(R.id.fieldGoalsTotalTextView)
        val fieldGoalsAttemptedTextView = itemView.findViewById<TextView>(R.id.fieldGoalsAttemptedTextView)
        val threesTotalTextView = itemView.findViewById<TextView>(R.id.threesTotalTextView)
        val threesAttemptedTextView = itemView.findViewById<TextView>(R.id.threesAttemptedTextView)
        val freeThrowsTotalTextView = itemView.findViewById<TextView>(R.id.freeThrowsTotalTextView)
        val freeThrowsAttemptedTextView = itemView.findViewById<TextView>(R.id.freeThrowsAttemptedTextView)
    }

    fun setPlayerSeasonShooting(playerSeasons: List<PlayerSeason>) {
        this.items = playerSeasons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonShootingPerGameItemHolder {
        val itemView = inflater.inflate(R.layout.stats_totals_layout, parent, false)
        return SeasonShootingPerGameItemHolder(itemView)
    }

    override fun getItemCount(): Int = items.size + 1

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SeasonShootingPerGameItemHolder, position: Int) {

        if (position == 0) {
            holder.yearTextView.text = "Year"
            holder.teamTextView.text = "Tm"
            holder.gamesPlayedTextView.text = "GP"
            holder.gamesStartedTextView.text = "GS"
            holder.fieldGoalsTotalTextView.text = "FG"
            holder.fieldGoalsAttemptedTextView.text = "FGA"
            holder.threesTotalTextView.text = "3P"
            holder.threesAttemptedTextView.text = "3PA"
            holder.freeThrowsTotalTextView.text = "FT"
            holder.freeThrowsAttemptedTextView.text = "FTA"

            holder.itemView.setBackgroundColor(alternateRowColor)
        }
        else {
            val rowColor = if (position % 2 == 0) alternateRowColor else whiteColor
            val currentItem = items[position - 1]

            if (currentItem.year == null)
                holder.yearTextView.displayValue("ALL")
            else
                holder.yearTextView.displayValue(currentItem.year)

            val team = if (currentItem.team.equals("Career")) "" else currentItem.team
            holder.teamTextView.displayValue(team)
            holder.gamesPlayedTextView.displayValue(currentItem.totalGamesPlayed)
            holder.gamesStartedTextView.displayValue(currentItem.totalGamesStarted)
            holder.fieldGoalsTotalTextView.displayValue(currentItem.fieldGoalsMadePerGame)
            holder.fieldGoalsAttemptedTextView.displayValue(currentItem.fieldGoalsAttemptedPerGame)
            holder.threesTotalTextView.displayValue(currentItem.threesMadePerGame)
            holder.threesAttemptedTextView.displayValue(currentItem.threesAttemptedPerGame)
            holder.freeThrowsTotalTextView.displayValue(currentItem.freeThrowsMadePerGame)
            holder.freeThrowsAttemptedTextView.displayValue(currentItem.freeThrowsAttemptedPerGame)

            holder.itemView.setBackgroundColor(rowColor)
        }
    }

}
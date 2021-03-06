package dev.randallgreene.basketballstats.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import dev.randallgreene.basketballstats.R
import dev.randallgreene.basketballstats.data.models.PlayerInfo
import dev.randallgreene.basketballstats.ui.convertYearRangeToYYYYHyphenYY


class AutoCompletePlayerNameAdapter(
    context: Context,
    playerNamesList: List<PlayerInfo>
) : ArrayAdapter<PlayerInfo>(context, 0, playerNamesList.toMutableList()) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val newConvertView = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.autocomplete_player_name_row, parent, false)

        val playerNameTextView = newConvertView.findViewById<TextView>(R.id.playerNameTextView)
        val playerYearTextView = newConvertView.findViewById<TextView>(R.id.playerYearTextView)

        val playerInfo = getItem(position)

        playerInfo?.run {
            playerNameTextView.text = playerInfo.name
            playerYearTextView.text =
                convertYearRangeToYYYYHyphenYY(
                    playerInfo.yearFrom,
                    playerInfo.yearTo
                )
        }

        return newConvertView
    }
}
package dev.randallgreene.basketballstats.data.models

import com.google.gson.annotations.SerializedName

data class Player(
    val player_id: String,
    val name: String,
    @SerializedName("year_from")
    val yearFrom: Int,
    @SerializedName("year_to")
    val yearTo: Int,
    val position: String?,
    val height: Int?,
    val weight: Int?,
    val birthdate: String?,
    val colleges: String?,
    @SerializedName("hall_of_fame")
    val hallOfFame: Boolean?,
    @SerializedName("regular_season_stats")
    val regularSeasonStats: List<PlayerSeason>,
    @SerializedName("playoff_stats")
    val playoffStats: List<PlayerSeason>
) {

}
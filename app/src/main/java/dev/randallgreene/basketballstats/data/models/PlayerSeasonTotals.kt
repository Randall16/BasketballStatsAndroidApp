package dev.randallgreene.basketballstats.data.models

import com.google.gson.annotations.SerializedName

data class PlayerSeasonTotals(
    val year: Int,
    val team: String,
    val age: Int?,
    @SerializedName("games_played")
    val gamesPlayed: Int?,
    @SerializedName("games_started")
    val gamesStarted: Int?,
    val minutes: Int?,
    @SerializedName("field_goals_made")
    val fieldGoalsMade: Int?,
    @SerializedName("field_goals_attempted")
    val fieldGoalsAttempted: Int?,
    @SerializedName("threes_made")
    val threesMade: Int?,
    @SerializedName("threes_attempted")
    val threesAttempted: Int?,
    @SerializedName("twos_made")
    val twosMade: Int?,
    @SerializedName("twos_attempted")
    val twosAttempted: Int?,
    @SerializedName("free_throws_made")
    val freeThrowsMade: Int?,
    @SerializedName("free_throws_attempted")
    val freeThrowsAttempted: Int?,
    @SerializedName("offensive_rebounds")
    val offensiveRebounds: Int?,
    @SerializedName("defensive_rebounds")
    val defensiveRebounds: Int?,
    @SerializedName("total_rebounds")
    val totalRebounds: Int?,
    val assists: Int?,
    val steals: Int?,
    val blocks: Int?,
    val turnovers: Int?,
    val personal_fouls: Int?,
    val points: Int?
)
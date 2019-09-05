package dev.randallgreene.basketballstats.data.models

import com.google.gson.annotations.SerializedName

// Using the @SerializedName annotation to convert api snake_case response into idiomatic Kotlin camelCase

data class PlayerSeasonAverages(
    val year: Int,
    val team: String,
    val age: Int?,
    @SerializedName("games_played")
    val gamesPlayed: Int?,
    @SerializedName("games_started")
    val gamesStarted: Int?,
    val minutes: Double?,
    @SerializedName("field_goal_percentage")
    val fieldGoalPercentage: Double?,
    @SerializedName("three_percentage")
    val threePercentage: Double?,
    @SerializedName("free_throw_percentage")
    val freeThrowPercentage: Double?,
    @SerializedName("offensive_rebounds")
    val offensiveRebounds: Double?,
    @SerializedName("defensive_rebounds")
    val defensiveRebounds: Double?,
    @SerializedName("total_rebounds")
    val totalRebounds: Double?,
    val assists: Double?,
    val steals: Double?,
    val blocks: Double?,
    val turnovers: Double?,
    @SerializedName("personal_fouls")
    val personalFouls: Double?,
    val points: Double?
)
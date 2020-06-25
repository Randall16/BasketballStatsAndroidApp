package dev.randallgreene.basketballstats.data.models

import com.google.gson.annotations.SerializedName

data class PlayerSeason(
    val year: Int?,
    val team: String?,
    val age: Int?,
    @SerializedName("total_games_played")
    val totalGamesPlayed: Int?,
    @SerializedName("total_games_started")
    val totalGamesStarted: Int?,
    @SerializedName("total_minutes")
    val totalMinutes: Int?,
    @SerializedName("total_field_goals_made")
    val totalFieldGoalsMade: Int?,
    @SerializedName("total_field_goals_attempted")
    val totalFieldGoalsAttempted: Int?,
    @SerializedName("total_threes_made")
    val totalThreesMade: Int?,
    @SerializedName("total_threes_attempted")
    val totalThreesAttempted: Int?,
    @SerializedName("total_twos_made")
    val totalTwosMade: Int?,
    @SerializedName("total_twos_attempted")
    val totalTwosAttempted: Int?,
    @SerializedName("total_free_throws_made")
    val totalFreeThrowsMade: Int?,
    @SerializedName("total_free_throws_attempted")
    val totalFreeThrowsAttempted: Int?,
    @SerializedName("total_offensive_rebounds")
    val totalOffensiveRebounds: Int?,
    @SerializedName("total_defensive_rebounds")
    val totalDefensiveRebounds: Int?,
    @SerializedName("total_rebounds")
    val totalRebounds: Int?,
    @SerializedName("total_assists")
    val totalAssists: Int?,
    @SerializedName("total_steals")
    val totalSteals: Int?,
    @SerializedName("total_blocks")
    val totalBlocks: Int?,
    @SerializedName("total_turnovers")
    val totalTurnovers: Int?,
    @SerializedName("total_personal_fouls")
    val totalPersonalFouls: Int?,
    @SerializedName("total_points")
    val totalPoints: Int?,
    @SerializedName("field_goal_percentage")
    val fieldGoalPercentage: Double?,
    @SerializedName("three_percentage")
    val threePercentage: Double?,
    @SerializedName("two_percentage")
    val twoPercentage: Double?,
    @SerializedName("free_throw_percentage")
    val freeThrowPercentage: Double?,
    @SerializedName("effective_field_goal_percentage")
    val effectiveFieldGoalPercentage: Double?,
    @SerializedName("true_shooting_percentage")
    val trueShootingPercentage: Double?,
    @SerializedName("field_goals_made_per_game")
    val fieldGoalsMadePerGame: Double?,
    @SerializedName("field_goals_attempted_per_game")
    val fieldGoalsAttemptedPerGame: Double?,
    @SerializedName("threes_made_per_game")
    val threesMadePerGame: Double?,
    @SerializedName("threes_attempted_per_game")
    val threesAttemptedPerGame: Double?,
    @SerializedName("twos_made_per_game")
    val twosMadePerGame: Double?,
    @SerializedName("twos_attempted_per_game")
    val twosAttemptedPerGame: Double?,
    @SerializedName("free_throws_made_per_game")
    val freeThrowsMadePerGame: Double?,
    @SerializedName("free_throws_attempted_per_game")
    val freeThrowsAttemptedPerGame: Double?,
    @SerializedName("minutes_per_game")
    val minutesPerGame: Double?,
    @SerializedName("offensive_rebounds_per_game")
    val offensiveReboundsPerGame: Double?,
    @SerializedName("defensive_rebounds_per_game")
    val defensiveReboundsPerGame: Double?,
    @SerializedName("total_rebounds_per_game")
    val totalReboundsPerGame: Double?,
    @SerializedName("assists_per_game")
    val assistsPerGame: Double?,
    @SerializedName("steals_per_game")
    val stealsPerGame: Double?,
    @SerializedName("blocks_per_game")
    val blocksPerGame: Double?,
    @SerializedName("turnovers_per_game")
    val turnoversPerGame: Double?,
    @SerializedName("personal_fouls_per_game")
    val personalFoulsPerGame: Double?,
    @SerializedName("points_per_game")
    val pointsPerGame: Double?
)
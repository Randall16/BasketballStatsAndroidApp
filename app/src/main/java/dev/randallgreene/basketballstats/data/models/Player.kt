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

    /*
    private fun calculteCareerAvreages(averages: List<PlayerSeasonAverages>): PlayerSeasonAverages {
        var gamesPlayed = averages[0].gamesPlayed
        var gamesStarted = averages[0].gamesStarted
        var minutes = averages[0].minutes
        var fieldGoalPercentage = averages[0].fieldGoalPercentage
        var threePercentage = averages[0].threePercentage
        var freeThrowPercentage = averages[0].freeThrowPercentage
        var offensiveRebounds = averages[0].offensiveRebounds
        var defensiveRebounds = averages[0].defensiveRebounds
        var totalRebounds = averages[0].totalRebounds
        var assists = averages[0].assists
        var steals = averages[0].steals
        var blocks = averages[0].blocks
        var turnovers = averages[0].turnovers
        var personalFouls = averages[0].personalFouls
        var points = averages[0].points

        for (i in 1..averages.size) {
            gamesPlayed += averages[i].gamesPlayed ?: null
            gamesStarted += averages[i].gamesStarted
            minutes += averages[i].minutes
            fieldGoalPercentage += averages[i].fieldGoalPercentage
            threePercentage += averages[i].threePercentage
            freeThrowPercentage += averages[i].freeThrowPercentage
            offensiveRebounds += averages[i].offensiveRebounds
            defensiveRebounds += averages[i].defensiveRebounds
            totalRebounds += averages[i].totalRebounds
            assists += averages[i].assists
            steals += averages[i].steals
            blocks += averages[i].blocks
            turnovers += averages[i].turnovers
            personalFouls += averages[i].personalFouls
            points += averages[i].points
        }
    }
    */
}
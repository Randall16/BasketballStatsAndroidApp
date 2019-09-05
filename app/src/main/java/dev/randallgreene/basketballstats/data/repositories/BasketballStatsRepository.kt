package dev.randallgreene.basketballstats.data.repositories

import dev.randallgreene.basketballstats.data.models.Player
import dev.randallgreene.basketballstats.data.models.PlayerInfo
import dev.randallgreene.basketballstats.data.networking.BasketballStatsAPI

class BasketballStatsRepository {

    private val basketballStatsAPI = BasketballStatsAPI.BasketballStatsAPI

    suspend fun fetchAllPlayerInfos(): List<PlayerInfo> {
        val playerInfos = basketballStatsAPI.fetchAllPlayerInfos().await()

        return playerInfos

        //return testList
    }

    suspend fun fetchPlayerByID(playerID: String): Player {
        val player = basketballStatsAPI.fetchPlayerByID(playerID).await()

        return player
    }

    // here temporarily for testing purposes, use this list to avoid making an api call
    private val testList = listOf<PlayerInfo>(
        PlayerInfo("jamesle01", "LeBron James", 2004, 2019, "F-G",
            80, 250, "1984-12-30", null, false)
    )
}
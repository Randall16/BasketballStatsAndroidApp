package dev.randallgreene.basketballstats.data.repositories

import androidx.annotation.WorkerThread
import dev.randallgreene.basketballstats.data.models.Player
import dev.randallgreene.basketballstats.data.models.PlayerInfo
import dev.randallgreene.basketballstats.data.networking.buildApiService

class BasketballStatsRepository {

    private val basketballStatsAPI = buildApiService()

    @WorkerThread
    suspend fun fetchAllPlayerInfos(): List<PlayerInfo> {
        //return basketballStatsAPI.fetchAllPlayerInfos().await()
        return testList
    }


    @WorkerThread
    suspend fun fetchPlayerByID(playerID: String): Player {
        val player = basketballStatsAPI.fetchPlayerByID(playerID).await()

        return player
    }

    // here temporarily for testing purposes, use this list to avoid making an api call while testing
    private val testList = listOf<PlayerInfo>(
        PlayerInfo("jamesle01", "LeBron James", 2004, 2019, "F-G",
            80, 250, "1984-12-30", null, false),
        PlayerInfo("gasolma01", "Marc Gasol", 2009, 2020, "C",
            80, 255, "1980-12-30", null, false)
    )
}
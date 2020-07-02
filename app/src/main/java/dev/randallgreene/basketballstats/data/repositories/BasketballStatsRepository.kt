package dev.randallgreene.basketballstats.data.repositories

import androidx.annotation.WorkerThread
import dev.randallgreene.basketballstats.data.models.Player
import dev.randallgreene.basketballstats.data.models.PlayerInfo
import dev.randallgreene.basketballstats.data.networking.Response
import dev.randallgreene.basketballstats.data.networking.buildApiService
import java.lang.Exception

class BasketballStatsRepository {

    private val basketballStatsAPI = buildApiService()

    @WorkerThread
    suspend fun fetchAllPlayerInfos(): Response<List<PlayerInfo>> {
        try {
            val playerInfos = basketballStatsAPI.fetchAllPlayerInfos().await()
            val sortedPlayerInfos = playerInfos.sortedByDescending { it.yearTo }
            return Response.Success(sortedPlayerInfos)
        } catch (exception: Exception) {
            return Response.Error(exception)
        }
    }


    @WorkerThread
    suspend fun fetchPlayerByID(playerID: String): Response<Player> {
        try {
            val player = basketballStatsAPI.fetchPlayerByID(playerID).await()
            return Response.Success(player)
        } catch (exception: Exception) {
            return Response.Error(exception)
        }
    }

    // here temporarily for testing purposes, use this list to avoid making an api call while testing
    private val testList = listOf<PlayerInfo>(
        PlayerInfo("jamesle01", "LeBron James", 2004, 2020, "F-G",
            80, 250, "1984-12-30", null, false),
        PlayerInfo("gasolma01", "Marc Gasol", 2009, 2020, "C",
            80, 255, "1980-12-30", null, false)
    )
}
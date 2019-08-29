package dev.randallgreene.basketballstats.data.repositories

import dev.randallgreene.basketballstats.data.models.PlayerInfo
import dev.randallgreene.basketballstats.data.networking.BasketballStatsAPI

class BasketballStatsRepository {

    private val basketballStatsAPI = BasketballStatsAPI.BasketballStatsAPI

    suspend fun fetchAllPlayerInfos(): List<PlayerInfo> {
        val playerInfos = basketballStatsAPI.fetchAllPlayerInfos().await()

        return playerInfos
    }
}
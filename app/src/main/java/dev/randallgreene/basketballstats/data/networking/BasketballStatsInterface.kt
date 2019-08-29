package dev.randallgreene.basketballstats.data.networking

import dev.randallgreene.basketballstats.data.models.PlayerInfo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header


interface BasketballStatsInterface {

    @GET("players")
    fun fetchAllPlayerInfos(@Header("x-api-key") apiKey: String = BASKETBALL_STATS_API_KEY)
            : Deferred<List<PlayerInfo>>

}
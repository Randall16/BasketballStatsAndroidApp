package dev.randallgreene.basketballstats.data.networking

import dev.randallgreene.basketballstats.data.models.Player
import dev.randallgreene.basketballstats.data.models.PlayerInfo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


private const val API_KEY_INDICATOR = "x-api-key"


interface BasketballStatsInterface {

    @GET("players")
    fun fetchAllPlayerInfos(@Header(API_KEY_INDICATOR) apiKey: String = BASKETBALL_STATS_API_KEY)
            : Deferred<List<PlayerInfo>>

    @GET("players/{player_id}")
    fun fetchPlayerByID(
        @Path("player_id") playerID: String,
        @Header(API_KEY_INDICATOR) apiKey: String = BASKETBALL_STATS_API_KEY
    ): Deferred<Player>

}
package dev.randallgreene.basketballstats.data.networking

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BasketballStatsAPI {

    // This is the default url given via AWS API gateway
    private const val BASE_URL = "https://jkl9ihhxtk.execute-api.us-east-1.amazonaws.com/testing/"

    /*private val okHttpClient = OkHttpClient().apply {
        it.networkInterceptors().add(OkHttpInterceptor())
    }

    private fun createClient(): OkClient {
        val client = OkHttpClient()
        client.networkInterceptors().add(OkHttpInterceptor())
        val okClient = OkClient(okHttpClient)
        return client
    }*/

    val BasketballStatsAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(OkHttpClient())
        .build()
        .create(BasketballStatsInterface::class.java)

}
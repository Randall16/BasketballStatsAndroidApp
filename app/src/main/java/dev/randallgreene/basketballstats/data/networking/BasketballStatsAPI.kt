package dev.randallgreene.basketballstats.data.networking

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val API_VERSION_NUMBER = 2
// This is the default url given via AWS API gateway
private const val BASE_URL = "https://nttidjtatb.execute-api.us-east-1.amazonaws.com/v$API_VERSION_NUMBER/"

fun buildApiService() = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(OkHttpClient())
    .build()
    .create(BasketballStatsInterface::class.java)
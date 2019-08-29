package dev.randallgreene.basketballstats.data.networking

import okhttp3.Interceptor
import okhttp3.Response

class OkHttpInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()

        val requestWithHeader = originalRequest.newBuilder()
            .header("x-api-key", BASKETBALL_STATS_API_KEY)
            .build()

        return chain.proceed(requestWithHeader)
    }
}
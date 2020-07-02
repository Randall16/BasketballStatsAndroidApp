package dev.randallgreene.basketballstats.data.networking

// Encapsulates whether API was a success or not
sealed class Response<out T> {
    data class Success<T>(val data: T) : Response<T>()
    data class Error(val throwable: Throwable) : Response<Nothing>()
}
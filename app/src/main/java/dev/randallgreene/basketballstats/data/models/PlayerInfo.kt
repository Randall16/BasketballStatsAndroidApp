package dev.randallgreene.basketballstats.data.models


data class PlayerInfo(
    val player_id: String,
    val name: String,
    val year_from: Int,
    val year_to: Int,
    val position: String?,
    val height: Int?,
    val weight: Int?,
    val birthdate: String?,
    val colleges: String?,
    val hall_of_fame: Boolean?
)
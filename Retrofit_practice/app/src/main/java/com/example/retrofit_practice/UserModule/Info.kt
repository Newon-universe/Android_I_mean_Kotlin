package com.example.retrofit_practice.UserModule

data class Info(
    val game_datetime: Long,
    val game_length: Double,
    val game_version: String,
    val participants: List<Participant>,
    val queue_id: Int,
    val tft_game_type: String,
    val tft_set_number: Int
)
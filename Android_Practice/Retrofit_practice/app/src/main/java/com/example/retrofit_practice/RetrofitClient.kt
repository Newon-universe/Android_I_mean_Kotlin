package com.example.retrofit_practice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginClient {

    val sRetrofit = initRetrofit()
    private const val USER_INFO_URL = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-name/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(USER_INFO_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}

object UserTierClient {

    val sRetrofit = initRetrofit()
    private const val USER_TIER_URL = "https://kr.api.riotgames.com/tft/league/v1/entries/by-summoner/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(USER_TIER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}

object GameNameClient{
    val sRetrofit = initRetrofit()
    private const val GAME_URL = "https://americas.api.riotgames.com/tft/match/v1/matches/by-puuid/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(GAME_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}

object GameClient {

    val sRetrofit = initRetrofit()
    private const val GAME_URL = "https://kr.api.riotgames.com/tft/league/v1/entries/by-summoner/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(GAME_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}
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
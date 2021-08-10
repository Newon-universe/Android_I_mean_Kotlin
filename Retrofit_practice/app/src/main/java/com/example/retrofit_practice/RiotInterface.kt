package com.example.retrofit_practice

import com.example.retrofit_practice.UserModule.UserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotInterface {

    @GET("{summonerName}")
    fun getUser(@Path("summonerName") summonerName : String,
                @Query("api_key") api_key:String) : Call<UserInfo>

}
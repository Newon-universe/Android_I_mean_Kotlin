package com.example.retrofit_practice

import com.example.retrofit_practice.UserModule.GameName
import com.example.retrofit_practice.UserModule.UserInfo
import com.example.retrofit_practice.UserModule.UserTier
import com.example.retrofit_practice.UserModule.UserTierItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotInterface {

    @GET("{summonerName}")
    fun getUser(@Path("summonerName") summonerName : String,
                @Query("api_key") api_key:String) : Call<UserInfo>


    @GET("{Id}")
    fun getUserTier(@Path("Id") Id: String,
                   @Query("api_key") api_key:String) : Call<UserTier>

    @GET("{globalId}/ids")
    fun getGameName(@Path("globalId")globalId: String,
                    @Query("count")count: Int,
                    @Query("api_key")api_key: String) : Call<GameName>


}
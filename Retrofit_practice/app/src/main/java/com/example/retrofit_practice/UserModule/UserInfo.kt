package com.example.retrofit_practice.UserModule

data class UserInfo(
    var accountId: String,
    var id: String,
    var name: String,
    var profileIconId: Int,
    var puuid: String,
    var revisionDate: Long,
    var summonerLevel: Int
)
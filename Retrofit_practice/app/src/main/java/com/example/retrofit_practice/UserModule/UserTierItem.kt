package com.example.retrofit_practice.UserModule

data class UserTierItem(
    val freshBlood: Boolean,
    val hotStreak: Boolean,
    val inactive: Boolean,
    val leagueId: String,
    val leaguePoints: Int,
    val losses: Int,
    val queueType: String,
    val rank: String,
    val ratedRating: Int,
    val ratedTier: String,
    val summonerId: String,
    val summonerName: String,
    val tier: String,
    val veteran: Boolean,
    val wins: Int
)
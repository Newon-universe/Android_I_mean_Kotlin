package com.example.retrofit_practice.UserModule

data class Metadata(
    val data_version: String,
    val match_id: String,
    val participants: List<String>
)
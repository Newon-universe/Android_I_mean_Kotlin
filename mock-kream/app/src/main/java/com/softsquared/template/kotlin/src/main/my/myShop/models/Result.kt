package com.softsquared.template.kotlin.src.main.my.myShop.models

data class Result(
    val buy: Buy,
    val grade: String,
    val like: Int,
    val mygoods: Mygoods,
    val name: String,
    val point: String,
    val profileimg: String,
    val profilename: String,
    val sell: Sell
)
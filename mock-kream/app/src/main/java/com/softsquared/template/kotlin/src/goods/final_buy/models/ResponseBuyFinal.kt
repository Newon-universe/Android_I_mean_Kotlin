package com.softsquared.template.kotlin.src.goods.final_buy.models

data class ResponseBuyFinal(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Int
)
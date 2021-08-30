package com.softsquared.template.kotlin.src.goods.models_immediately_buy

data class ResponseImmediatelyBuy(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)
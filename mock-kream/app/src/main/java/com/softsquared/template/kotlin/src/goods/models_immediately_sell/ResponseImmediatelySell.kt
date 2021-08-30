package com.softsquared.template.kotlin.src.goods.models_immediately_sell

data class ResponseImmediatelySell(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)
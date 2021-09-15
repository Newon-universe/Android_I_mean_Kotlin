package com.softsquared.template.kotlin.src.main.shop.models

data class ResponseShopTop(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)
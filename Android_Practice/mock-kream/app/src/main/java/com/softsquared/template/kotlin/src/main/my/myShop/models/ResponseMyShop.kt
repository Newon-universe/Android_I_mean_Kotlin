package com.softsquared.template.kotlin.src.main.my.myShop.models

data class ResponseMyShop(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)
package com.softsquared.template.kotlin.src.main.home.home_today.models

data class ResponseHomeToday(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)
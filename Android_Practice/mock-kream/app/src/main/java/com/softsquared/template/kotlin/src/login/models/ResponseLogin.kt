package com.softsquared.template.kotlin.src.login.models

data class ResponseLogin(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)
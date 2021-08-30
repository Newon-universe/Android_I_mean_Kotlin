package com.softsquared.template.kotlin.src.login.sign_up.models

data class ResponsePostSignUp(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: String
)
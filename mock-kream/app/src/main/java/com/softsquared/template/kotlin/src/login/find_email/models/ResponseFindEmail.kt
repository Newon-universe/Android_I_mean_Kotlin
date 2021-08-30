package com.softsquared.template.kotlin.src.login.find_email.models

data class ResponseFindEmail(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)
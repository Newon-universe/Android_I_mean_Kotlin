package com.softsquared.template.kotlin.src.goods.models

data class ResponseGoods(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)
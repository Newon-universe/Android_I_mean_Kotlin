package com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models

data class ResponseGetGoodsLike(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)
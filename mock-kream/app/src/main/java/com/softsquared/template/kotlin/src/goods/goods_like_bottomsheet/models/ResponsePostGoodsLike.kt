package com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class ResponsePostGoodsLike (
    @SerializedName("isSuccess") var isSuccess: Boolean = false,
    @SerializedName("code") var code: Int = 0,
    @SerializedName("message") var message: String? = null
)
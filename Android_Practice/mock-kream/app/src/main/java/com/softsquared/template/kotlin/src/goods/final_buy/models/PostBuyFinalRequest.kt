package com.softsquared.template.kotlin.src.goods.final_buy.models

import com.google.gson.annotations.SerializedName

data class PostBuyFinalRequest (
    @SerializedName("goodsidx") val goodsidx:Int,
    @SerializedName("size") val size:Int,
    @SerializedName("price") val price:Int
)
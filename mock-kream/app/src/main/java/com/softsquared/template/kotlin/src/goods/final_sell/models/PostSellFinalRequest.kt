package com.softsquared.template.kotlin.src.goods.final_sell.models

import com.google.gson.annotations.SerializedName

class PostSellFinalRequest (
    @SerializedName("goodsidx") val goodsidx:Int,
    @SerializedName("size") val size:Int
    )
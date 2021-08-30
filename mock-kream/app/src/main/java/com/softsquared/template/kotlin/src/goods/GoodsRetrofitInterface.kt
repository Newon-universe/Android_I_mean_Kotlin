package com.softsquared.template.kotlin.src.goods

import com.softsquared.template.kotlin.src.goods.models.ResponseGoods
import com.softsquared.template.kotlin.src.goods.models_immediately_buy.ResponseImmediatelyBuy
import com.softsquared.template.kotlin.src.goods.models_immediately_sell.ResponseImmediatelySell
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GoodsRetrofitInterface {

    @GET("/goods/{idx}")
    fun getGoodsMain(@Path("idx") idx: Int) : Call<ResponseGoods>

    @GET("/buy-good/{goodsidx}/1000")
    fun getImmediatelyBuy(@Path("goodsidx") goodsidx:Int) : Call<ResponseImmediatelyBuy>

    @GET("/sell-good/{goodsidx}/1000")
    fun getImmediatelySell(@Path("goodsidx") goodsidx:Int) : Call<ResponseImmediatelySell>

}
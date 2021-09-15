package com.softsquared.template.kotlin.src.goods.final_sell

import com.softsquared.template.kotlin.src.goods.final_sell.models.PostSellFinalRequest
import com.softsquared.template.kotlin.src.goods.final_sell.models.ResponseSellFinal
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SellFinalRetrofitInterface {

    @POST("/sell-good/")
    fun postSellFinal(@Body params: PostSellFinalRequest): Call<ResponseSellFinal>
}
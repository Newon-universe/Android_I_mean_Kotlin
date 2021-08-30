package com.softsquared.template.kotlin.src.goods.final_buy

import com.softsquared.template.kotlin.src.goods.final_buy.models.PostBuyFinalRequest
import com.softsquared.template.kotlin.src.goods.final_buy.models.ResponseBuyFinal
import com.softsquared.template.kotlin.src.login.models.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BuyFinalRetrofitInterface {

    @POST("/buy-good/")
    fun postBuyFinal(@Body params: PostBuyFinalRequest): Call<ResponseBuyFinal>


}